package org.epineuro.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.epineuro.dto.PatientDTO;
import org.epineuro.request.DiseaseRequest;
import org.epineuro.request.PatientRequest;
import org.epineuro.service.DiseaseService;
import org.epineuro.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService service;
	
	
	@Autowired
	private DiseaseService dService;
	
	@GetMapping
	public List<PatientDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid PatientRequest request) {
		Set<DiseaseRequest> c = new HashSet<DiseaseRequest>();
		c = request.getComorbities();
		c.forEach(dis -> dService.salvar(dis));
		PatientDTO patient = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(patient.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
}

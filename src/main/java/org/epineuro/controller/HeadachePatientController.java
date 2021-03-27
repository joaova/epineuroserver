package org.epineuro.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.request.DiseaseRequest;
import org.epineuro.request.HeadachePatientRequest;
import org.epineuro.service.DiseaseService;
import org.epineuro.service.HeadachePatientService;
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
@RequestMapping("/headache")
public class HeadachePatientController {

	@Autowired
	private HeadachePatientService service;
	
	@Autowired
	private DiseaseService dService;
	
	@GetMapping
	public List<HeadachePatientDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid HeadachePatientRequest request) {
		Set<DiseaseRequest> c = new HashSet<DiseaseRequest>();
		c = request.getComorbities();
		c.forEach(dis -> dService.salvar(dis));
		HeadachePatientDTO headache = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(headache.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
}

package org.epineuro.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.epineuro.dto.PatientDTO;
import org.epineuro.model.Patient;
import org.epineuro.request.DiseaseRequest;
import org.epineuro.request.DrugsRequest;
import org.epineuro.request.ExamRequest;
import org.epineuro.request.MedicationRequest;
import org.epineuro.request.PatientRequest;
import org.epineuro.service.DiseaseService;
import org.epineuro.service.DrugService;
import org.epineuro.service.ExamService;
import org.epineuro.service.MedicationService;
import org.epineuro.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private DrugService drugsService;

	@Autowired
	private MedicationService medService;

	@Autowired
	private ExamService exService;
	
	@GetMapping("/pagination/{page}/{pageSize}")
	public List<PatientDTO> listByPage(@PathVariable Integer page, @PathVariable Integer pageSize) {
		return service.listByPage(page, pageSize);
	}

	@GetMapping
	public List<PatientDTO> list() {
		return service.list();
	}

	@GetMapping("/{id}")
	public PatientDTO search(@PathVariable Long id) {
		return service.searchById(id);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid PatientRequest request) {
		Set<DiseaseRequest> c = new HashSet<DiseaseRequest>();
		c = request.getComorbities();
		c.forEach(dis -> dService.salvar(dis));

		Set<DrugsRequest> dru = new HashSet<DrugsRequest>();
		dru = request.getDrugs();
		dru.forEach(dis -> drugsService.salvar(dis));

		Set<DiseaseRequest> familyC = new HashSet<DiseaseRequest>();
		familyC = request.getFirstDegreeRelative();
		familyC.forEach(dis -> dService.salvar(dis));

		Set<ExamRequest> ex = new HashSet<ExamRequest>();
		ex = request.getExams();
		ex.forEach(dis -> exService.salvar(dis));

		Set<MedicationRequest> med = new HashSet<MedicationRequest>();
		med = request.getMedications();
		med.forEach(dis -> medService.salvar(dis));	

		Patient patient = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(patient.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Long id) {
		service.deletePatient(id);
	}
	
	
	
}

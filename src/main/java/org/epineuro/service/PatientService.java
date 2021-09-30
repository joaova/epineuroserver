package org.epineuro.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.PatientCompleteDTO;
import org.epineuro.dto.PatientDTO;
import org.epineuro.exception.PatientNotFoundException;
import org.epineuro.mapper.PatientMapper;
import org.epineuro.model.Patient;
import org.epineuro.repository.PatientRepository;
import org.epineuro.request.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	 
	@Autowired 
	private PatientRepository repository;
	                                     
	@Autowired
	private PatientMapper mapper;
	
	public List<PatientDTO> listByPage(Integer page, Integer pageSize) {
		Pageable firstPageWithFiveElements = PageRequest.of(page, pageSize);

		Page<Patient> patient =  repository.findAll(firstPageWithFiveElements);
		return patient.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}

	public List<PatientDTO> list() {
		List<Patient> patient = repository.findAll();
		return patient.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public List<PatientCompleteDTO> fList() {
		List<Patient> patient = repository.findAll();
		return patient.stream()
					  .map(p -> mapper.modelToCompleteDTO(p))
					  .collect(Collectors.toList());
	}

	public PatientDTO searchById(Long id) {
		return repository.findById(id)
			.map(p -> mapper.modelToDTO(p))
			.orElseThrow(() -> new PatientNotFoundException(id));
	}

	public PatientCompleteDTO fSearch(Long id) {
		return repository.findById(id)
			.map(p -> mapper.modelToCompleteDTO(p))
			.orElseThrow(() -> new PatientNotFoundException(id));
	}

	@Transactional
	public Patient salvar(PatientRequest request) {
		Patient p = mapper.dtoRequestToModel(request);
		return repository.save(p);
	}

	@Transactional
	public ResponseEntity<?> deletePatient(Long id) {
		
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}

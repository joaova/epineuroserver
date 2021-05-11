package org.epineuro.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.PatientDTO;
import org.epineuro.mapper.PatientMapper;
import org.epineuro.model.Patient;
import org.epineuro.repository.PatientRepository;
import org.epineuro.request.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired 
	private PatientRepository repository;
	                                     
	@Autowired
	private PatientMapper mapper;
	
	public List<PatientDTO> listar() {
		List<Patient> patient = repository.findAll();
		return patient.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	@Transactional
	public Patient salvar(PatientRequest request) {
		Patient p = mapper.dtoRequestToModel(request);
		return repository.save(p);
	}
}

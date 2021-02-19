package org.epineuro.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.mapper.HeadachePatientMapper;
import org.epineuro.model.HeadachePatient;
import org.epineuro.repository.HeadachePatientRepository;
import org.epineuro.request.HeadachePatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HeadachePatientService {
	
	@Autowired
	private HeadachePatientRepository repository;
	
	@Autowired
	private HeadachePatientMapper mapper;
	
	public List<HeadachePatientDTO> listar() {
		List<HeadachePatient> headache = repository.findAll();
		return headache.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	@Transactional
	public HeadachePatientDTO salvar(HeadachePatientRequest request) {
		HeadachePatient h = mapper.dtoRequestToModel(request);
		
		return mapper.modelToDTO(repository.save(h));
	}
	
	
}

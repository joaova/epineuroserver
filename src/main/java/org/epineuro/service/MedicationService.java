package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.MedicationDTO;
import org.epineuro.mapper.MedicationMapper;
import org.epineuro.model.Medication;
import org.epineuro.repository.MedicationRepository;
import org.epineuro.request.MedicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
 
    @Autowired
	private MedicationRepository repository;
	
	@Autowired
	private MedicationMapper mapper;
	
	public List<MedicationDTO> listar() {
		List<Medication> med = repository.findAll();
		return med.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public MedicationDTO buscar(String id) {
		
		Optional<Medication> med = repository.findById(id);
				
		if(med.isPresent()) {
			return mapper.modelToDTO(med.get());
		}
		
		return null;	
	}
	

	@Transactional
	public MedicationDTO salvar(MedicationRequest request) {
		Medication m = mapper.dtoRequestToModel(request);
		return mapper.modelToDTO(repository.save(m));
	}
	
	@Transactional
	public void atualizar(Medication obj) {
		repository.save(obj);
	}    

}

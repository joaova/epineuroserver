package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.mapper.HeadachePatientMapper;
import org.epineuro.model.HeadachePatient;
import org.epineuro.repository.HeadachePatientRepository;
import org.epineuro.request.HeadachePatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class HeadachePatientService {
	
	@Autowired
	private HeadachePatientRepository repository;
	
	@Autowired
	private HeadachePatientMapper mapper;
	
	public List<HeadachePatientDTO> listar(Integer pageSize) {

    	Pageable firstPageWithFiveElements = PageRequest.of(0, pageSize);

		Page<HeadachePatient> headache =  repository.findAll(firstPageWithFiveElements);
		return headache.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}

	public HeadachePatientDTO search(Long id) {
		Optional<HeadachePatient> hP = repository.findById(id);

		if (hP.isPresent()) {
			return mapper.modelToDTO(hP.get());
		}

		return null;
		
	}
					  
	
	@Transactional
	public HeadachePatientDTO salvar(HeadachePatientRequest request) {
		HeadachePatient h = mapper.dtoRequestToModel(request);
		return mapper.modelToDTO(repository.save(h));
	}
	
	@Transactional
	public HeadachePatientDTO edit(HeadachePatientRequest newPatient, Long id) {
		HeadachePatient hPatient = mapper.dtoRequestToModel(newPatient);
		return mapper.modelToDTO(repository.findById(id)
			.map(patient -> {
				patient.setGender(hPatient.getGender());
				patient.setBirthState(hPatient.getBirthState());
				patient.setBirthCity(hPatient.getBirthCity());
				patient.setCurrentCity(hPatient.getCurrentCity());
				patient.setBirthDate(hPatient.getBirthDate());
				patient.setComorbities(hPatient.getComorbities());
				return repository.save(patient);
			})
			.orElseGet(() -> {
				newPatient.setId(id);

				return repository.save(hPatient);
			}));
	}

}

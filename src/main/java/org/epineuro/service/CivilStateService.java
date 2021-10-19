package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.CivilStateDTO;
import org.epineuro.mapper.CivilStateMapper;
import org.epineuro.model.CivilState;
import org.epineuro.repository.CivilStateRepository;
import org.epineuro.request.CivilStateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilStateService {
	
	@Autowired
	private CivilStateRepository repository;
	
	@Autowired
	private CivilStateMapper mapper;
	
	public List<CivilStateDTO> listar() {
		List<CivilState> CivilStates = repository.findAll();
		return CivilStates.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public CivilStateDTO buscar(Long id) {
		
		Optional<CivilState> CivilState = repository.findById(id);
				
		if(CivilState.isPresent()) {
			return mapper.modelToDTO(CivilState.get());
		}
		
		return null;	
	}
	

	@Transactional
	public CivilStateDTO salvar(CivilStateRequest request) {
		CivilState d = mapper.dtoRequestToModel(request);

		Optional<CivilState> CivilState = repository.findById(request.getId());
				
		if(CivilState.isPresent()) {
			return mapper.modelToDTO(CivilState.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(CivilState obj) {
		repository.save(obj);
	}
	
}

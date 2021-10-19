package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.ScholarityDTO;
import org.epineuro.mapper.ScholarityMapper;
import org.epineuro.model.Scholarity;
import org.epineuro.repository.ScholarityRepository;
import org.epineuro.request.ScholarityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarityService {
	
	@Autowired
	private ScholarityRepository repository;
	
	@Autowired
	private ScholarityMapper mapper;
	
	public List<ScholarityDTO> listar() {
		List<Scholarity> Scholaritys = repository.findAll();
		return Scholaritys.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public ScholarityDTO buscar(Long id) {
		
		Optional<Scholarity> Scholarity = repository.findById(id);
				
		if(Scholarity.isPresent()) {
			return mapper.modelToDTO(Scholarity.get());
		}
		
		return null;	
	}
	

	@Transactional
	public ScholarityDTO salvar(ScholarityRequest request) {
		Scholarity d = mapper.dtoRequestToModel(request);

		Optional<Scholarity> Scholarity = repository.findById(request.getId());
				
		if(Scholarity.isPresent()) {
			return mapper.modelToDTO(Scholarity.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(Scholarity obj) {
		repository.save(obj);
	}
	
}

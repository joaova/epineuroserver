package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.DrugsDTO;
import org.epineuro.mapper.DrugsMapper;
import org.epineuro.model.Drugs;
import org.epineuro.repository.DrugsRepository;
import org.epineuro.request.DrugsRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DrugService {

    @Autowired
	private DrugsRepository repository;
	
	@Autowired
	private DrugsMapper mapper;
	
	public List<DrugsDTO> listar() {
		List<Drugs> exams = repository.findAll();
		return exams.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public DrugsDTO buscar(String id) {
		
		Optional<Drugs> dru = repository.findById(id);
				
		if(dru.isPresent()) {
			return mapper.modelToDTO(dru.get());
		}
		
		return null;	
	}
	

	@Transactional
	public DrugsDTO salvar(DrugsRequest request) {
		Drugs d = mapper.dtoRequestToModel(request);

		Optional<Drugs> drugs = repository.findById(d.getName());
				
		if(drugs.isPresent()) {
			return mapper.modelToDTO(drugs.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(Drugs obj) {
		repository.save(obj);
	}

}

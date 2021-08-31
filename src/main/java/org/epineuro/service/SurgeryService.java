package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.SurgeryDTO;
import org.epineuro.mapper.SurgeryMapper;
import org.epineuro.model.Surgery;
import org.epineuro.repository.SurgeryRepository;
import org.epineuro.request.SurgeryRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SurgeryService {

    @Autowired
	private SurgeryRepository repository;
	
	@Autowired
	private SurgeryMapper mapper;
	
	public List<SurgeryDTO> listar() {
		List<Surgery> surgery = repository.findAll();
		return surgery.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public SurgeryDTO buscar(String id) {
		
		Optional<Surgery> dru = repository.findById(id);
				
		if(dru.isPresent()) {
			return mapper.modelToDTO(dru.get());
		}
		
		return null;	
	}
	

	@Transactional
	public SurgeryDTO salvar(SurgeryRequest request) {
		Surgery d = mapper.dtoRequestToModel(request);

		Optional<Surgery> surgery = repository.findById(d.getName());
				
		if(surgery.isPresent()) {
			return mapper.modelToDTO(surgery.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(Surgery obj) {
		repository.save(obj);
	}

}
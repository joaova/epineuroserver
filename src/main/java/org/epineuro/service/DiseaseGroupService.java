package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.DiseaseGroupDTO;
import org.epineuro.mapper.DiseaseGroupMapper;
import org.epineuro.model.DiseaseGroup;
import org.epineuro.repository.DiseaseGroupRepository;
import org.epineuro.request.DiseaseGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseGroupService {
	
	@Autowired
	private DiseaseGroupRepository repository;
	
	@Autowired
	private DiseaseGroupMapper mapper;
	
	public List<DiseaseGroupDTO> listar() {
		List<DiseaseGroup> DiseaseGroups = repository.findAll();
		return DiseaseGroups.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public DiseaseGroupDTO buscar(Long id) {
		
		Optional<DiseaseGroup> DiseaseGroup = repository.findById(id);
				
		if(DiseaseGroup.isPresent()) {
			return mapper.modelToDTO(DiseaseGroup.get());
		}
		
		return null;	
	}
	

	@Transactional
	public DiseaseGroupDTO salvar(DiseaseGroupRequest request) {
		DiseaseGroup d = mapper.dtoRequestToModel(request);

		Optional<DiseaseGroup> DiseaseGroup = repository.findById(request.getId());
				
		if(DiseaseGroup.isPresent()) {
			return mapper.modelToDTO(DiseaseGroup.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(DiseaseGroup obj) {
		repository.save(obj);
	}
	
}

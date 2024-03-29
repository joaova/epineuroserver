package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.mapper.DiseaseMapper;
import org.epineuro.model.Disease;
import org.epineuro.repository.DiseaseRepository;
import org.epineuro.request.DiseaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
	
	@Autowired
	private DiseaseRepository repository;
	
	@Autowired
	private DiseaseMapper mapper;
	
	public List<DiseaseDTO> listar() {
		List<Disease> diseases = repository.findAll();
		return diseases.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public DiseaseDTO buscar(String codigo) {
		
		Optional<Disease> disease = repository.findById(codigo);
				
		if(disease.isPresent()) {
			return mapper.modelToDTO(disease.get());
		}
		
		return null;	
	}
	

	@Transactional
	public DiseaseDTO salvar(DiseaseRequest request) {
		Disease d = mapper.dtoRequestToModel(request);

		Optional<Disease> disease = repository.findById(request.getId());
				
		if(disease.isPresent()) {
			return mapper.modelToDTO(disease.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(Disease obj) {
		repository.save(obj);
	}
	
}

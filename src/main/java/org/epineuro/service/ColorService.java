package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.ColorDTO;
import org.epineuro.mapper.ColorMapper;
import org.epineuro.model.Color;
import org.epineuro.repository.ColorRepository;
import org.epineuro.request.ColorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository repository;
	
	@Autowired
	private ColorMapper mapper;
	
	public List<ColorDTO> listar() {
		List<Color> Colors = repository.findAll();
		return Colors.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public ColorDTO buscar(Long id) {
		
		Optional<Color> Color = repository.findById(id);
				
		if(Color.isPresent()) {
			return mapper.modelToDTO(Color.get());
		}
		
		return null;	
	}
	

	@Transactional
	public ColorDTO salvar(ColorRequest request) {
		Color d = mapper.dtoRequestToModel(request);

		Optional<Color> Color = repository.findById(request.getId());
				
		if(Color.isPresent()) {
			return mapper.modelToDTO(Color.get());
		}

		return mapper.modelToDTO(repository.save(d));
	}
	
	@Transactional
	public void atualizar(Color obj) {
		repository.save(obj);
	}
	
}

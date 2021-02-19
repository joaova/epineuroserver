package org.epineuro.mapper;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.model.Disease;
import org.epineuro.request.DiseaseRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiseaseMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DiseaseDTO modelToDTO(Disease Disease) {
		return modelMapper.map(Disease, DiseaseDTO.class);
	}

	public Disease dtoRequestToModel(DiseaseRequest DiseaseRequest) {
		return modelMapper.map(DiseaseRequest, Disease.class);
	}
	
}

package org.epineuro.mapper;

import org.epineuro.dto.DiseaseGroupDTO;
import org.epineuro.model.DiseaseGroup;
import org.epineuro.request.DiseaseGroupRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiseaseGroupMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DiseaseGroupDTO modelToDTO(DiseaseGroup DiseaseGroup) {
		return modelMapper.map(DiseaseGroup, DiseaseGroupDTO.class);
	}

	public DiseaseGroup dtoRequestToModel(DiseaseGroupRequest DiseaseGroupRequest) {
		return modelMapper.map(DiseaseGroupRequest, DiseaseGroup.class);
	}
	
}

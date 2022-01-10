package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

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

	public Set<DiseaseGroup> DiseaseGroupRequestToModel(Set<DiseaseGroupRequest> dR) {
		
		if (dR != null) {
			return dR.stream()
			.map(dis -> modelMapper.map(dis, DiseaseGroup.class))
			.collect(Collectors.toSet());
		}

		return null;
				
	}

	
	public Set<DiseaseGroupDTO> DiseaseGroupToDTO(Set<DiseaseGroup> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, DiseaseGroupDTO.class))
				.collect(Collectors.toSet());
	}
	
}

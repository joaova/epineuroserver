package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

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
	
	public DiseaseDTO modelToDTO(Disease disease) {
		return modelMapper.map(disease, DiseaseDTO.class);
	}

	public Disease dtoRequestToModel(DiseaseRequest diseaseRequest) {
		return modelMapper.map(diseaseRequest, Disease.class);
	}
	
	public Set<Disease> comorbitiesRequestToModel(Set<DiseaseRequest> dR) {
		
		return dR.stream()
				.map(dis -> modelMapper.map(dis, Disease.class))
				.collect(Collectors.toSet());		
	}

	
	public Set<DiseaseDTO> comorbitiesToDTO(Set<Disease> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, DiseaseDTO.class))
				.collect(Collectors.toSet());
	}
	
}

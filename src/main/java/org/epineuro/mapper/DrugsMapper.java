package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.epineuro.dto.DrugsDTO;
import org.epineuro.model.Drugs;
import org.epineuro.request.DrugsRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugsMapper {
    @Autowired
	private ModelMapper modelMapper;
	
	public DrugsDTO modelToDTO(Drugs drugs) {
		return modelMapper.map(drugs, DrugsDTO.class);
	}

	public Drugs dtoRequestToModel(DrugsRequest drugsRequest) {
		return modelMapper.map(drugsRequest, Drugs.class);
	}
	
	public Set<Drugs> drugsRequestToModel(Set<DrugsRequest> dR) {
		
		if (dR != null) {
			return dR.stream()
			.map(dis -> modelMapper.map(dis, Drugs.class))
			.collect(Collectors.toSet());
		}

		return null;
				
	}

	
	public Set<DrugsDTO> drugsToDTO(Set<Drugs> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, DrugsDTO.class))
				.collect(Collectors.toSet());
	}
}

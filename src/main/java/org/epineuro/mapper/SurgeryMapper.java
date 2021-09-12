package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.epineuro.dto.SurgeryDTO;
import org.epineuro.model.Surgery;
import org.epineuro.request.SurgeryRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurgeryMapper {
    @Autowired
	private ModelMapper modelMapper;
	
	public SurgeryDTO modelToDTO(Surgery surgery) {
		return modelMapper.map(surgery, SurgeryDTO.class);
	}

	public Surgery dtoRequestToModel(SurgeryRequest surgeryRequest) {
		return modelMapper.map(surgeryRequest, Surgery.class);
	}
	
	public Set<Surgery> SurgeryRequestToModel(Set<SurgeryRequest> dR) {
		
		if (dR != null) {
			return dR.stream()
			.map(dis -> modelMapper.map(dis, Surgery.class))
			.collect(Collectors.toSet());
		}
		return null;		
	}

	
	public Set<SurgeryDTO> SurgeryToDTO(Set<Surgery> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, SurgeryDTO.class))
				.collect(Collectors.toSet());
	}
}

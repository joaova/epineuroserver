package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.epineuro.dto.CivilStateDTO;
import org.epineuro.model.CivilState;
import org.epineuro.request.CivilStateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CivilStateMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CivilStateDTO modelToDTO(CivilState CivilState) {
		return modelMapper.map(CivilState, CivilStateDTO.class);
	}

	public CivilState dtoRequestToModel(CivilStateRequest CivilStateRequest) {
		return modelMapper.map(CivilStateRequest, CivilState.class);
	}
	
	public Set<CivilState> comorbitiesRequestToModel(Set<CivilStateRequest> dR) {
		
		if (dR != null) {
			return dR.stream()
			.map(dis -> modelMapper.map(dis, CivilState.class))
			.collect(Collectors.toSet());
		}

		return null;	
	}

	
	public Set<CivilStateDTO> comorbitiesToDTO(Set<CivilState> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, CivilStateDTO.class))
				.collect(Collectors.toSet());
	}
	
}

package org.epineuro.mapper;

import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.model.HeadachePatient;
import org.epineuro.request.HeadachePatientRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadachePatientMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public HeadachePatientDTO modelToDTO(HeadachePatient headache) {
		return modelMapper.map(headache, HeadachePatientDTO.class);
	}

	public HeadachePatient dtoRequestToModel(HeadachePatientRequest headacheRequest) {
		return modelMapper.map(headacheRequest, HeadachePatient.class);
	}
	
}

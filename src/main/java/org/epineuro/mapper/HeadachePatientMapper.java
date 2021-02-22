package org.epineuro.mapper;

import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.enums.Gender;
import org.epineuro.model.HeadachePatient;
import org.epineuro.request.HeadachePatientRequest;
import org.springframework.stereotype.Component;

@Component
public class HeadachePatientMapper {
	
	public HeadachePatientDTO modelToDTO(HeadachePatient headache) {
//		return modelMapper.map(headache, HeadachePatientDTO.class);
		HeadachePatientDTO hpDTO = new HeadachePatientDTO(headache.getId(), headache.getGenderCod(), 
				headache.getBirthState(), headache.getBirthCity(), headache.getCurrentCity(), 
				headache.getBirthDate(), headache.getComorbities(), headache.getPainPattern());
		return hpDTO;
		
	}

	public HeadachePatient dtoRequestToModel(HeadachePatientRequest headacheRequest) {
//		return modelMapper.map(headacheRequest, HeadachePatient.class);
		HeadachePatient hp = new HeadachePatient(headacheRequest.getId(), Gender.toEnum(headacheRequest.getGender()), 
				headacheRequest.getBirthState(), headacheRequest.getBirthCity(), headacheRequest.getCurrentCity(), 
				headacheRequest.getBirthDate(), headacheRequest.getComorbities(), headacheRequest.getPainPattern());
		return hp;
	}
	
}

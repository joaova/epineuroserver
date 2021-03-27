package org.epineuro.mapper;

import java.util.Set;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.enums.Gender;
import org.epineuro.model.Disease;
import org.epineuro.model.HeadachePatient;
import org.epineuro.request.HeadachePatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadachePatientMapper {
	
	@Autowired
	private DiseaseMapper mapper;
	
	public HeadachePatientDTO modelToDTO(HeadachePatient headache) {
//		return modelMapper.map(headache, HeadachePatientDTO.class);
		Set<DiseaseDTO> comorbities = mapper.comorbitiesToDTO(headache.getComorbities());
		HeadachePatientDTO hpDTO = new HeadachePatientDTO(headache.getId(), headache.getGenderCod(), 
				headache.getBirthState(), headache.getBirthCity(), headache.getCurrentCity(), 
				headache.getBirthDate(), comorbities, headache.getPainPattern());
		return hpDTO;
		
	}

	public HeadachePatient dtoRequestToModel(HeadachePatientRequest headacheRequest) {
//		return modelMapper.map(headacheRequest, HeadachePatient.class);
		Set<Disease> comorbities = mapper.comorbitiesRequestToModel(headacheRequest.getComorbities());
		HeadachePatient hp = new HeadachePatient(headacheRequest.getId(), Gender.toEnum(headacheRequest.getGender()), 
				headacheRequest.getBirthState(), headacheRequest.getBirthCity(), headacheRequest.getCurrentCity(), 
				headacheRequest.getBirthDate(), comorbities, headacheRequest.getPainPattern());
		return hp;
	}
	
}

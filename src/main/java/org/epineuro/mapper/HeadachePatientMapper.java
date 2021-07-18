package org.epineuro.mapper;

import java.util.Set;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.dto.HeadachePatientDTO;
import org.epineuro.enums.DiseaseGroup;
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
		Set<DiseaseDTO> comorbities = mapper.comorbitiesToDTO(headache.getComorbities());
		HeadachePatientDTO hpDTO = new HeadachePatientDTO(headache.getId(), headache.getGenderCod(), 
				headache.getBirthState(), headache.getBirthCity(), headache.getCurrentCity(), 
				headache.getBirthDate(), headache.getDiseaseGroupCod(), comorbities, headache.getPainPattern());
		return hpDTO;
		
	}

	public HeadachePatient dtoRequestToModel(HeadachePatientRequest headacheRequest) {
		Set<Disease> comorbities = mapper.comorbitiesRequestToModel(headacheRequest.getComorbities());
		HeadachePatient hp = new HeadachePatient(headacheRequest.getId(), Gender.toEnum(headacheRequest.getGender()), 
				headacheRequest.getBirthState(), headacheRequest.getBirthCity(), headacheRequest.getCurrentCity(), 
				headacheRequest.getBirthDate(), DiseaseGroup.toEnum(headacheRequest.getDiseaseGroup()) ,comorbities, headacheRequest.getPainPattern());
		System.out.println(comorbities);
		return hp;
	}
	
}

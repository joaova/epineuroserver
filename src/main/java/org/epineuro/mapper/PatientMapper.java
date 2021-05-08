package org.epineuro.mapper;

import java.util.Set;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.dto.PatientDTO;
import org.epineuro.enums.Gender;
import org.epineuro.model.Disease;
import org.epineuro.model.Patient;
import org.epineuro.request.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

	@Autowired
	private DiseaseMapper mapper;
	
	public PatientDTO modelToDTO(Patient patient) {
//		return modelMapper.map(patient, patientPatientDTO.class);
		Set<DiseaseDTO> comorbities = mapper.comorbitiesToDTO(patient.getComorbities());
		PatientDTO pDTO = new PatientDTO(patient.getId(), patient.getGenderCod(), 
				patient.getBirthState(), patient.getBirthCity(), patient.getCurrentCity(), 
				patient.getBirthDate(), comorbities);
		System.out.println(pDTO);
		return pDTO;
		
	}

	public Patient dtoRequestToModel(PatientRequest patientRequest) {
//		return modelMapper.map(patientRequest, patientPatient.class);
		Set<Disease> comorbities = mapper.comorbitiesRequestToModel(patientRequest.getComorbities());
		Patient p = new Patient(patientRequest.getId(), Gender.toEnum(patientRequest.getGender()), 
				patientRequest.getBirthState(), patientRequest.getBirthCity(), patientRequest.getCurrentCity(), 
				patientRequest.getBirthDate(), comorbities);
		System.out.println(p);
		return p;
	}
	
}

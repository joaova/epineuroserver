package org.epineuro.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.epineuro.dto.PatientDTO;
import org.epineuro.enums.DiseaseGroup;
import org.epineuro.enums.Gender;
import org.epineuro.model.Disease;
import org.epineuro.model.Patient;
import org.epineuro.request.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

	// @Autowired
	// private ModelMapper modelMapper;
	
	@Autowired
	private DiseaseMapper mapper;
	
	// Quando precisar de novo disso, lembrar que é assim por conta do enum. Talvez precise alterar
	// novamente por conta de diseasegroup
	
//	public PatientDTO modelToDTO(Patient patient) {
////		return modelMapper.map(patient, patientPatientDTO.class);
//		Set<DiseaseDTO> comorbities = mapper.comorbitiesToDTO(patient.getComorbities());
//		PatientDTO pDTO = new PatientDTO(patient.getId(), patient.getGenderCod(), 
//				patient.getBirthState(), patient.getBirthCity(), patient.getCurrentCity(), 
//				patient.getBirthDate(), comorbities);
//		System.out.println(pDTO);
//		return pDTO;
//		
//	}
	
	public PatientDTO modelToDTO(Patient patient) {
		// String mainDisease = patient.getComorbities().iterator().next().getNome();
		
		PatientDTO pDTO = new PatientDTO(patient.getId(), patient.getGenderCod(), 
				patient.getCurrentCity(), ageCalc(patient.getBirthDate(), LocalDate.now()), patient.getDiseaseGroupCod());
		System.out.println(pDTO);
		return pDTO;
		
//		return modelMapper.map(patient, PatientDTO.class);
	}

	public Patient dtoRequestToModel(PatientRequest patientRequest) {
//		return modelMapper.map(patientRequest, patientPatient.class);
		Set<Disease> comorbities = mapper.comorbitiesRequestToModel(patientRequest.getComorbities());
		Patient p = new Patient(patientRequest.getId(), Gender.toEnum(patientRequest.getGender()), 
				patientRequest.getBirthState(), patientRequest.getBirthCity(), patientRequest.getCurrentCity(), 
				patientRequest.getBirthDate(), DiseaseGroup.toEnum(patientRequest.getDiseaseGroup()) ,comorbities);
		System.out.println(p);
		return p;
	}
	
	public Integer ageCalc(LocalDate birthDate, LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
}

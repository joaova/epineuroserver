package org.epineuro.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.dto.DrugsDTO;
import org.epineuro.dto.ExamDTO;
import org.epineuro.dto.MedicationDTO;
import org.epineuro.dto.PatientCompleteDTO;
import org.epineuro.dto.PatientDTO;
import org.epineuro.enums.CivilState;
import org.epineuro.enums.Color;
import org.epineuro.enums.DiseaseGroup;
import org.epineuro.enums.Gender;
import org.epineuro.enums.Job;
import org.epineuro.enums.Religion;
import org.epineuro.enums.Scholarity;
import org.epineuro.model.Disease;
import org.epineuro.model.Drugs;
import org.epineuro.model.Exam;
import org.epineuro.model.Medication;
import org.epineuro.model.Patient;
import org.epineuro.request.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

	// @Autowired
	// private ModelMapper modelMapper;
	
	@Autowired
	private DiseaseMapper diseaseMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private MedicationMapper medicationMapper;
	@Autowired
	private DrugsMapper drugsMapper;

	
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

	public PatientCompleteDTO modelToCompleteDTO(Patient patient) {
		Set<DiseaseDTO> comorbities = diseaseMapper.comorbitiesToDTO(patient.getComorbities());
		Set<DiseaseDTO> firstDegreeRelative = diseaseMapper.comorbitiesToDTO(patient.getFirstDegreeRelative());
		Set<DrugsDTO> drugs = drugsMapper.drugsToDTO(patient.getDrugs());
		Set<MedicationDTO> medications = medicationMapper.medicationToDTO(patient.getMedication());
		Set<ExamDTO> exams = examMapper.examToDTO(patient.getExams());
		PatientCompleteDTO pcDTO = new PatientCompleteDTO(patient.getId(), patient.getGenderCod(), patient.getColorCod(),
		patient.getCivilStateCod(), patient.getScholarityCod(), patient.getBirthState(), patient.getBirthCity(), patient.getCurrentCity(),
		patient.getJobCod(), patient.getReligionCod(), patient.getBirthDate(), patient.getStartOutpatientFollowUp(), patient.getEndOutpatientFollowUp(),
		patient.getDischargeDate(), patient.getDiseaseGroupCod(), comorbities, patient.getBmi(), patient.getSmoking(),
		patient.getAlcoholism(), drugs, patient.getPreviousNeurosurgery(),firstDegreeRelative, exams, medications);
		return pcDTO;
	}

	public Patient dtoRequestToModel(PatientRequest patientRequest) {
//		return modelMapper.map(patientRequest, patientPatient.class);
		Set<Disease> comorbities = diseaseMapper.comorbitiesRequestToModel(patientRequest.getComorbities());
		Set<Disease> firstDegreeRelative = diseaseMapper.comorbitiesRequestToModel(patientRequest.getFirstDegreeRelative());
		Set<Drugs> drugs = drugsMapper.drugsRequestToModel(patientRequest.getDrugs());
		Set<Medication> medications = medicationMapper.medicationRequestToModel(patientRequest.getMedications());
		Set<Exam> exams = examMapper.examRequestToModel(patientRequest.getExams());
		Patient p = new Patient(patientRequest.getId(), Gender.toEnum(patientRequest.getGender()), Color.toEnum(patientRequest.getColor()), 
				CivilState.toEnum(patientRequest.getCivilState()), Scholarity.toEnum(patientRequest.getScholarity()), 
				patientRequest.getBirthState(), patientRequest.getBirthCity(), patientRequest.getCurrentCity(), Job.toEnum(patientRequest.getJob()), Religion.toEnum(patientRequest.getReligion()),
				patientRequest.getBirthDate(), patientRequest.getStartOutpatientFollowUp(), patientRequest.getEndOutpatientFollowUp(), patientRequest.getDischargeDate(), 
				DiseaseGroup.toEnum(patientRequest.getDiseaseGroup()) ,comorbities, patientRequest.getBmi(), patientRequest.getSmoking(), patientRequest.getAlcoholism(), 
				drugs, patientRequest.getPreviousNeurosurgery(), firstDegreeRelative, exams, medications);

		System.out.println(p);
		return p;
	}
	
	public Integer ageCalc(LocalDate birthDate, LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
}

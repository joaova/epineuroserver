package org.epineuro.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.epineuro.dto.CivilStateDTO;
import org.epineuro.dto.ColorDTO;
import org.epineuro.dto.DiseaseDTO;
import org.epineuro.dto.DiseaseGroupDTO;
import org.epineuro.dto.DrugsDTO;
import org.epineuro.dto.ExamDTO;
import org.epineuro.dto.MedicationDTO;
import org.epineuro.dto.PatientCompleteDTO;
import org.epineuro.dto.PatientDTO;
import org.epineuro.dto.ScholarityDTO;
import org.epineuro.dto.SurgeryDTO;
import org.epineuro.enums.Gender;
import org.epineuro.model.CivilState;
import org.epineuro.model.Color;
import org.epineuro.model.Disease;
import org.epineuro.model.DiseaseGroup;
import org.epineuro.model.Drugs;
import org.epineuro.model.Exam;
import org.epineuro.model.Medication;
import org.epineuro.model.Patient;
import org.epineuro.model.Scholarity;
import org.epineuro.model.Surgery;
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
	@Autowired
	private SurgeryMapper surgMapper;
	@Autowired
	private DiseaseGroupMapper dGMapper;
	@Autowired
	private ColorMapper cMapper;
	@Autowired 
	private CivilStateMapper cVMapper;
	@Autowired
	private ScholarityMapper sMapper;


	
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
				patient.getCurrentCity(), ageCalc(patient.getBirthDate(), LocalDate.now()), patient.getDiseaseGroup());
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
		Set<SurgeryDTO> surgs = surgMapper.SurgeryToDTO(patient.getPreviousNeurosurgery());
		Set<DiseaseGroupDTO> dg = dGMapper.DiseaseGroupToDTO(patient.getDiseaseGroup());
		CivilStateDTO cv = cVMapper.modelToDTO(patient.getCivilState());
		ScholarityDTO s = sMapper.modelToDTO(patient.getScholarity());
		ColorDTO c = cMapper.modelToDTO(patient.getColor());
		


		PatientCompleteDTO pcDTO = new PatientCompleteDTO(patient.getId(), patient.getGenderCod(), c,
		cv, s, patient.getBirthState(), patient.getBirthCity(), patient.getCurrentCity(),
		patient.getJob(), patient.getBirthDate(), patient.getStartOutpatientFollowUp(), patient.getEndOutpatientFollowUp(), dg, comorbities, patient.getSmoking(),
		patient.getAlcoholism(), drugs, surgs,firstDegreeRelative, exams, medications, patient.getPatientUpdated());
		return pcDTO;
	}

	public Patient dtoRequestToModel(PatientRequest patientRequest) {
//		return modelMapper.map(patientRequest, patientPatient.class);

		Set<Disease> firstDegreeRelative = diseaseMapper.comorbitiesRequestToModel(patientRequest.getFirstDegreeRelative());
		Set<Drugs> drugs = drugsMapper.drugsRequestToModel(patientRequest.getDrugs());
		Set<Disease> comorbities = diseaseMapper.comorbitiesRequestToModel(patientRequest.getComorbities());
		Set<Medication> medications = medicationMapper.medicationRequestToModel(patientRequest.getMedications());
		Set<Exam> exams = examMapper.examRequestToModel(patientRequest.getExams());
		Set<Surgery> surgs = surgMapper.SurgeryRequestToModel(patientRequest.getPreviousNeurosurgery());
		Set<DiseaseGroup> dg = dGMapper.DiseaseGroupRequestToModel(patientRequest.getDiseaseGroup());
		CivilState cv = cVMapper.dtoRequestToModel(patientRequest.getCivilState());
		Scholarity s = sMapper.dtoRequestToModel(patientRequest.getScholarity());
		Color c = cMapper.dtoRequestToModel(patientRequest.getColor());
		

		Patient p = new Patient(patientRequest.getId(), Gender.toEnum(patientRequest.getGender()), c, 
				cv, s, patientRequest.getBirthState(), patientRequest.getBirthCity(), patientRequest.getCurrentCity(), patientRequest.getJob(),
				patientRequest.getBirthDate(), patientRequest.getStartOutpatientFollowUp(), patientRequest.getEndOutpatientFollowUp(),
				dg ,comorbities, patientRequest.getSmoking(), patientRequest.getAlcoholism(), 
				drugs, surgs, firstDegreeRelative, exams, medications, LocalDate.now());

		System.out.println(p);
		return p;
	}
	
	public Integer ageCalc(LocalDate birthDate, LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
}

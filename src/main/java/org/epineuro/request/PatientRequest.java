package org.epineuro.request;

import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class PatientRequest {

	private Long id;
	private Integer gender;
	private ColorRequest color;
	private CivilStateRequest civilState;
	private ScholarityRequest scholarity;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private String job;
	private LocalDate birthDate;
	private LocalDate startOutpatientFollowUp;
	private LocalDate endOutpatientFollowUp;
	private Set<DiseaseGroupRequest> diseaseGroup;
	private Set<DiseaseRequest> comorbities;
	private Integer smoking;
	private Integer alcoholism;
	private Set<DrugsRequest> drugs;
	private Set<SurgeryRequest> previousNeurosurgery;
	private Set<DiseaseRequest> firstDegreeRelative;
	private Set<ExamRequest> exams;
	private Set<MedicationRequest> medications;
	private LocalDate patientUpdated;

}
 
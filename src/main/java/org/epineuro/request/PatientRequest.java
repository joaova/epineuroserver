package org.epineuro.request;

import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
public class PatientRequest {

	private Long id;
	private Integer gender;
	private Integer color;
	private Integer civilState;
	private Integer scholarity;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private Integer job;
	private Integer religion;
	private LocalDate birthDate;
	private LocalDate startOutpatientFollowUp;
	private LocalDate endOutpatientFollowUp;
	private LocalDate dischargeDate;
	private Integer diseaseGroup;
	private Set<DiseaseRequest> comorbities;
	private String bmi;
	private Integer smoking;
	private Integer alcoholism;
	private Set<DrugsRequest> drugs;
	private Integer previousNeurosurgery;
	private Set<DiseaseRequest> firstDegreeRelative;
	private Set<ExamRequest> exams;
	private Set<MedicationRequest> medications;

}
 
package org.epineuro.dto;

import java.time.LocalDate;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientCompleteDTO {
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
	private Set<DiseaseDTO> comorbities;
	private String bmi;
	private Integer smoking;
	private Integer alcoholism;
	private Set<DrugsDTO> drugs;
	private Set<SurgeryDTO> previousNeurosurgery;
	private Set<DiseaseDTO> firstDegreeRelative;
	private Set<ExamDTO> CNSEvaluation;
	private Set<MedicationDTO> medications;
}

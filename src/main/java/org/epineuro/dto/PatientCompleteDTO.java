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
	private ColorDTO color;
	private CivilStateDTO civilState;
	private ScholarityDTO scholarity;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private String job;
	private LocalDate birthDate;
	private LocalDate startOutpatientFollowUp;
	private LocalDate endOutpatientFollowUp;
	private DiseaseGroupDTO diseaseGroup;
	private Set<DiseaseDTO> comorbities;
	private Integer smoking;
	private Integer alcoholism;
	private Set<DrugsDTO> drugs;
	private Set<SurgeryDTO> previousNeurosurgery;
	private Set<DiseaseDTO> firstDegreeRelative;
	private Set<ExamDTO> CNSEvaluation;
	private Set<MedicationDTO> medications;
	private LocalDate patientUpdated;
}

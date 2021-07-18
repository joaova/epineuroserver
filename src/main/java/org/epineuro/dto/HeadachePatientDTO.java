package org.epineuro.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeadachePatientDTO {
	
	private Long id;
	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private LocalDate birthDate;
	private Integer diseaseGroup;
	private Set<DiseaseDTO> comorbities;
	private String painPattern;
	
}

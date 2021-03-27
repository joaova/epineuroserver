package org.epineuro.dto;

import java.util.Date;
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
	private Date birthDate;
	private Set<DiseaseDTO> comorbities;
	private String painPattern;
	
}

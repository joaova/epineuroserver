package org.epineuro.dto;

import java.util.Date;
import java.util.Set;

import org.epineuro.model.Disease;

import lombok.Data;

@Data
public class HeadachePatientDTO {
	
	private Long id;
	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private Date birthDate;
	private Set<Disease> comorbities;
	private String painPattern;
	
}

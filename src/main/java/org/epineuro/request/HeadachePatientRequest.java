package org.epineuro.request;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class HeadachePatientRequest {
	private Long id;
	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private Date birthDate;
	private Set<DiseaseRequest> comorbities;
	private String painPattern;

}

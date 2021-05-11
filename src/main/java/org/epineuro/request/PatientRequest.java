package org.epineuro.request;

import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class PatientRequest {
	private Long id;
	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private LocalDate birthDate;
	private Set<DiseaseRequest> comorbities;
}

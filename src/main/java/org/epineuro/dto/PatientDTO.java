package org.epineuro.dto;

import org.epineuro.enums.DiseaseGroup;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PatientDTO {

	private Long id;
	private Integer gender;
	private String currentCity;
	private Integer age;
	private Integer diseaseGroup;
//	private Date birthDate;
//	private String diseaseGroup;
//	private String birthState;
//	private String birthCity;
	
}

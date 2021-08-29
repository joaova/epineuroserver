package org.epineuro.dto;

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
	
}

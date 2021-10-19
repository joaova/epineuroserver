package org.epineuro.dto;

import org.epineuro.model.DiseaseGroup;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PatientDTO {

	private Long id;
	private Integer gender;
	private String currentCity;
	private Integer age;
	private DiseaseGroup diseaseGroup;
	
}

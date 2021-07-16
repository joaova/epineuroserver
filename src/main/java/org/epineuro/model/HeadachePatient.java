package org.epineuro.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;

import org.epineuro.enums.DiseaseGroup;
import org.epineuro.enums.Gender;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class HeadachePatient extends Patient {
	
	private String painPattern;
	

	public HeadachePatient(Long id, Gender gender, String birthState, String birthCity, String currentCity,
			LocalDate birthDate, DiseaseGroup diseaseGroup, Set<Disease> comorbities, String painPattern) {
		super(id, gender, birthState, birthCity, currentCity, birthDate, diseaseGroup, comorbities);
		this.painPattern = painPattern;
	}

	public String getPainPattern() {
		return painPattern;
	}

	public void setPainPattern(String painPattern) {
		this.painPattern = painPattern;
	}
	
	

		
}

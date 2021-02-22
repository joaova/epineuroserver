package org.epineuro.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;

import org.epineuro.enums.Gender;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class HeadachePatient extends Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String painPattern;
	

	public HeadachePatient(Long id, Gender gender, String birthState, String birthCity, String currentCity,
			Date birthDate, Set<Disease> comorbities, String painPattern) {
		super(id, gender, birthState, birthCity, currentCity, birthDate, comorbities);
		this.painPattern = painPattern;
	}

	public String getPainPattern() {
		return painPattern;
	}

	public void setPainPattern(String painPattern) {
		this.painPattern = painPattern;
	}
	
	

		
}

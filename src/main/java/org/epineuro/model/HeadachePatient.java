package org.epineuro.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HeadachePatient extends Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String painPattern;

	public String getPainPattern() {
		return painPattern;
	}

	public void setPainPattern(String painPattern) {
		this.painPattern = painPattern;
	}
		
}

package org.epineuro.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.epineuro.enums.Gender;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@MappedSuperclass
@Data
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
//	private Integer diseaseGroup;
//	preciso de uma forma de relacionar as tabelas de headache e patient, talvez com uma chave secundaria
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthDate;
	
	@ManyToMany
	@JoinTable(name = "patient_disease", joinColumns = @JoinColumn(name = "patient_id"),
			inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> comorbities = new HashSet<Disease>();
	
	public Gender getSexo() {
		return Gender.toEnum(gender);
	}

	public void setGender(Gender gender) {
		this.gender = gender.getCod();
	}

}

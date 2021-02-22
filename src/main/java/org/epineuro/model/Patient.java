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

import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
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
	
	public Patient(Long id, Gender gender, String birthState, String birthCity, String currentCity, Date birthDate,
			Set<Disease> comorbities) {
		super();
		this.id = id;
		this.gender = (gender==null) ? null : gender.getCod();
		this.birthState = birthState;
		this.birthCity = birthCity;
		this.currentCity = currentCity;
		this.birthDate = birthDate;
		this.comorbities = comorbities;
	}
	
	
	
	public Gender getGender() {
		return Gender.toEnum(gender);
	}
	
	public Integer getGenderCod() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender.getCod();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBirthState() {
		return birthState;
	}



	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}



	public String getBirthCity() {
		return birthCity;
	}



	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}



	public String getCurrentCity() {
		return currentCity;
	}



	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public Set<Disease> getComorbities() {
		return comorbities;
	}



	public void setComorbities(Set<Disease> comorbities) {
		this.comorbities = comorbities;
	}


}

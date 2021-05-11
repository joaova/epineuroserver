package org.epineuro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.epineuro.enums.Gender;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer gender;
	private String birthState;
	private String birthCity;
	private String currentCity;
	
	// Fazer igual Sexo (enum)
//	private Integer diseaseGroup;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate birthDate;
	
	@ManyToMany
	@JoinTable(name = "patient_disease", joinColumns = @JoinColumn(name = "patient_id"),
			inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> comorbities; //= new HashSet<Disease>();
	
	public Patient(Long id, Gender gender, String birthState, String birthCity, String currentCity, LocalDate birthDate,
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



	public LocalDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}



	public Set<Disease> getComorbities() {
		return comorbities;
	}



	public void setComorbities(Set<Disease> comorbities) {
		this.comorbities = comorbities;
	}

}

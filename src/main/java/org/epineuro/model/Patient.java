package org.epineuro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.epineuro.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	// variáveis de identificação

	@Id
	private Long id;
	
	// Objetos próprios da tabela
	private String birthState;
	private String birthCity;
	private String currentCity;
	private String job;
	
	// Remetem à outra tabela
	private Integer gender;

	@ManyToOne
	@JoinColumn(name="color_id", nullable=true) 
	private Color color;

	@ManyToOne
	@JoinColumn(name="civil_state_id", nullable=true) 
	private CivilState civilState;

	@ManyToOne
	@JoinColumn(name="scholarity_id", nullable=true) 
	private Scholarity scholarity;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	// acompanhamento ambulatorial

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startOutpatientFollowUp;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endOutpatientFollowUp;

	@ManyToMany
	@JoinTable(name = "patient_disease_group", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "disease_group_id"))
	private Set<DiseaseGroup> diseaseGroup;

	@ManyToMany
	@JoinTable(name = "patient_disease", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> comorbities;

	// fatores de risco

	private Integer smoking;
	private Integer alcoholism;
	
	@ManyToMany
	@JoinTable(name = "patient_drugs", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "drug_id"))
	private Set<Drugs> drugs;

	@ManyToMany
	@JoinTable(name = "patient_surgeries", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "surgery_id"))
	private Set<Surgery> previousNeurosurgery;

	@ManyToMany
	@JoinTable(name = "family_history", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> firstDegreeRelative;

	// other

	@ManyToMany
	@JoinTable(name = "patient_exams", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "complementary_exams_id"))
	private Set<Exam> exams;

	@ManyToMany
	@JoinTable(name = "patient_medication", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "medication_id"))
	private Set<Medication> medications;

	private LocalDate patientUpdated;

	public Patient(Long id, Gender gender, Color color, CivilState civilState, Scholarity scholarity, String birthState, String birthCity, String currentCity, 
			String job, LocalDate birthDate, LocalDate startOutpatientFollowUp, LocalDate endOutpatientFollowUp,
			Set<DiseaseGroup> diseaseGroup, Set<Disease> comorbities, Integer smoking, Integer alcoholism, Set<Drugs> drugs, Set<Surgery> previousNeurosurgery,
			Set<Disease> firstDegreeRelative, Set<Exam> exams, Set<Medication> medications, LocalDate patientUpdated) {

		super();
		this.id = id;
		this.gender = (gender == null) ? null : gender.getCod();
		this.color = color;
		this.civilState = civilState;
		this.scholarity = scholarity;
		this.birthState = birthState;
		this.birthCity = birthCity;
		this.currentCity = currentCity;
		this.job = job;
		this.birthDate = birthDate;
		this.startOutpatientFollowUp = startOutpatientFollowUp;
		this.endOutpatientFollowUp = endOutpatientFollowUp;
		this.diseaseGroup = diseaseGroup;
		this.comorbities = comorbities;
		this.smoking = smoking;
		this.alcoholism = alcoholism;
		this.drugs =  drugs;
		this.previousNeurosurgery = previousNeurosurgery;
		this.firstDegreeRelative = firstDegreeRelative;
		this.exams = exams;
		this.medications = medications;
		this.patientUpdated = patientUpdated;

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

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public LocalDate getPatientUpdated() {
		return this.patientUpdated;
	}

	public void setPatientUpdated(LocalDate patientUpdated) {
		this.patientUpdated = patientUpdated;
	}

	public CivilState getCivilState() {
		return this.civilState;
	}

	public void setCivilState(CivilState civilState) {
		this.civilState = civilState;;
	}

	public Scholarity getScholarity() {
		return this.scholarity;
	}

	public void setScholarity(Scholarity scholarity) {
		this.scholarity = scholarity;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Set<DiseaseGroup> getDiseaseGroup() {
		return this.diseaseGroup;
	}

	public void setDiseaseGroup(Set<DiseaseGroup> disG) {
		this.diseaseGroup = disG;
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

	public LocalDate getStartOutpatientFollowUp() {
		return startOutpatientFollowUp;
	}

	public void setStartOutpatientFollowUp(LocalDate startOutpatientFollowUp) {
		this.startOutpatientFollowUp = startOutpatientFollowUp;
	}

	public LocalDate getEndOutpatientFollowUp() {
		return endOutpatientFollowUp;
	}

	public void setEndOutpatientFollowUp(LocalDate endOutpatientFollowUp) {
		this.endOutpatientFollowUp = endOutpatientFollowUp;
	}

	public Set<Disease> getComorbities() {
		return comorbities;
	}

	public void setComorbities(Set<Disease> comorbities) {
		this.comorbities = comorbities;
	}

	public Set<Drugs> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drugs> drugs) {
		this.drugs = drugs;
	}

	public Set<Disease> getFirstDegreeRelative() {
		return firstDegreeRelative;
	}

	public void setFirstDegreeRelative(Set<Disease> firstDegreeRelative) {
		this.firstDegreeRelative = firstDegreeRelative;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	public Set<Medication> getMedication() {
		return medications;
	}

	public void setMedication(Set<Medication> medications) {
		this.medications = medications;
	}

	public Integer getSmoking() {
		return smoking;
	}

	public void setSmoking(Integer smoking) {
		this.smoking = smoking;
	}

	public Integer getAlcoholism() {
		return alcoholism;
	}

	public void setAlcoholism(Integer alcoholism) {
		this.alcoholism = alcoholism;
	}

	public Set<Surgery> getPreviousNeurosurgery() {
		return previousNeurosurgery;
	}

	public void setPreviousNeurosurgery(Set<Surgery> previousNeurosurgery) {
		this.previousNeurosurgery = previousNeurosurgery;
	}


}

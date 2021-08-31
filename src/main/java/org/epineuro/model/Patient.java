package org.epineuro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.epineuro.enums.CivilState;
import org.epineuro.enums.Color;
import org.epineuro.enums.DiseaseGroup;
import org.epineuro.enums.Gender;
import org.epineuro.enums.Job;
import org.epineuro.enums.Religion;
import org.epineuro.enums.Scholarity;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	private Integer gender;
	private Integer color;
	private Integer civilState;
	private Integer scholarity;
	private String birthState;
	private String birthCity;
	private String currentCity;
	private Integer job;
	private Integer religion;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	// acompanhamento ambulatorial

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startOutpatientFollowUp;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endOutpatientFollowUp;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dischargeDate;

	private Integer diseaseGroup;

	@ManyToMany
	@JoinTable(name = "patient_disease", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> comorbities;

	// fatores de risco

	private String bmi;
	private Integer smoking;
	private Integer alcoholism;
	
	@ManyToMany
	@JoinTable(name = "patient_drugs", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "drug_id"))
	private Set<Drugs> drugs;

	private Integer previousNeurosurgery;

	@ManyToMany
	@JoinTable(name = "relatives_disease", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
	private Set<Disease> firstDegreeRelative;

	// other

	@ManyToMany
	@JoinTable(name = "complementary_exams", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "complementary_exams_id"))
	private Set<Exam> exams;

	@ManyToMany
	@JoinTable(name = "patient_medication", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "medication_id"))
	private Set<Medication> medications;

	public Patient(Long id, Gender gender, Color color, CivilState civilState, Scholarity scholarity, String birthState, String birthCity, String currentCity, 
			Job job, Religion religion, LocalDate birthDate, LocalDate startOutpatientFollowUp, LocalDate endOutpatientFollowUp, LocalDate dischargeDate,
			DiseaseGroup diseaseGroup, Set<Disease> comorbities, String bmi, Integer smoking, Integer alcoholism, Set<Drugs> drugs, Integer previousNeurosurgery,
			Set<Disease> firstDegreeRelative, Set<Exam> exams, Set<Medication> medications) {

		super();
		this.id = id;
		this.gender = (gender == null) ? null : gender.getCod();
		this.color = (color == null) ? null : color.getCod();
		this.civilState = (civilState == null) ? null : civilState.getCod();
		this.scholarity = (scholarity == null) ? null : scholarity.getCod();
		this.birthState = birthState;
		this.birthCity = birthCity;
		this.currentCity = currentCity;
		this.job = (job == null) ? null : job.getCod();
		this.religion = (religion == null) ? null : religion.getCod();
		this.birthDate = birthDate;
		this.startOutpatientFollowUp = startOutpatientFollowUp;
		this.endOutpatientFollowUp = endOutpatientFollowUp;
		this.dischargeDate = dischargeDate;
		this.diseaseGroup = (diseaseGroup == null) ? null : diseaseGroup.getCod();
		this.comorbities = comorbities;
		this.bmi = bmi;
		this.smoking = smoking;
		this.alcoholism = alcoholism;
		this.drugs =  drugs;
		this.previousNeurosurgery = previousNeurosurgery;
		this.firstDegreeRelative = firstDegreeRelative;
		this.exams = exams;
		this.medications = medications;

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
		return Color.toEnum(color);
	}

	public Integer getColorCod() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color.getCod();
	}

	public CivilState getCivilState() {
		return CivilState.toEnum(civilState);
	}

	public Integer getCivilStateCod() {
		return this.civilState;
	}

	public void setCivilState(CivilState civilState) {
		this.civilState = civilState.getCod();
	}

	public Scholarity getScholarity() {
		return Scholarity.toEnum(scholarity);
	}

	public Integer getScholarityCod() {
		return this.scholarity;
	}

	public void setScholarity(Scholarity scholarity) {
		this.scholarity = scholarity.getCod();
	}

	public Job getJob() {
		return Job.toEnum(job);
	}

	public Integer getJobCod() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job.getCod();
	}

	public Religion getReligion() {
		return Religion.toEnum(religion);
	}

	public Integer getReligionCod() {
		return this.religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion.getCod();
	}

	public DiseaseGroup getDiseaseGroup() {
		return DiseaseGroup.toEnum(diseaseGroup);
	}

	public Integer getDiseaseGroupCod() {
		return this.diseaseGroup;
	}

	public void setDiseaseGroup(DiseaseGroup disG) {
		this.diseaseGroup = disG.getCod();
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

	public LocalDate getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
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

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
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

	public Integer getPreviousNeurosurgery() {
		return previousNeurosurgery;
	}

	public void setPreviousNeurosurgery(Integer previousNeurosurgery) {
		this.previousNeurosurgery = previousNeurosurgery;
	}


}

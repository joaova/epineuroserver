package org.epineuro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="exames")
public class Exam {
	
	@Id
	private String name;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate examDate;
	
}

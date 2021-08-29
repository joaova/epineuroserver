package org.epineuro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="exames")
public class Exam {
	
	@Id
	private String name;
	
}

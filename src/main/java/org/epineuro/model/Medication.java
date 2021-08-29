package org.epineuro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medication {
    
    @Id
    private Long id;
    
	private String name;
	private String dailyDosage;

}
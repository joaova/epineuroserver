package org.epineuro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Medication {
    
    @Id
    private Long id;
	private String name;

}

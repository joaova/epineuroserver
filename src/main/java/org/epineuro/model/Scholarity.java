package org.epineuro.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Scholarity {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy="scholarity")
    private Set<Patient> patients;
}

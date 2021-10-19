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
public class CivilState {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy="civilState")
    private Set<Patient> patients;
}

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DiseaseGroup {

    @Id
    private Long id;
    private String groupName;

    @OneToMany(mappedBy="diseaseGroup")
    private Set<Patient> patients;

}

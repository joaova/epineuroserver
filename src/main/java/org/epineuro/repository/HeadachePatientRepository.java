package org.epineuro.repository;

import org.epineuro.model.HeadachePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadachePatientRepository extends JpaRepository<HeadachePatient, Long>{
    
}

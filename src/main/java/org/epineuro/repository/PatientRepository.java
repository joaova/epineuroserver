package org.epineuro.repository;

import org.epineuro.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    //TODO
    // @Query("from PatientDTO p where ()")
    // List<PatientDTO> findAll();

}

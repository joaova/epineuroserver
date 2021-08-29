package org.epineuro.repository;

import java.util.Optional;
import java.util.Set;

import org.epineuro.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>{

    @Query("SELECT m FROM Medication m WHERE m.name = :name")
	Optional<Set<Medication>> findByName(String name);

}

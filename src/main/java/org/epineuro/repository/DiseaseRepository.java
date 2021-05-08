package org.epineuro.repository;

import java.util.Optional;

import org.epineuro.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long>{
	
	@Query("SELECT d FROM Disease d WHERE d.codigo = :cid")
	Optional<Disease> findByCid(String cid);
	
}

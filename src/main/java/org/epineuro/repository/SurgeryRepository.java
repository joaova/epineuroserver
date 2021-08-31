package org.epineuro.repository;

import org.epineuro.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, String>{
	
}

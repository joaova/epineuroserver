package org.epineuro.repository;

import org.epineuro.model.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsRepository extends JpaRepository<Drugs, Long>{
    
}

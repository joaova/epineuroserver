package org.epineuro.repository;

import org.epineuro.model.DiseaseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseGroupRepository extends JpaRepository<DiseaseGroup, Long> {
    
}

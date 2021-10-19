package org.epineuro.repository;

import org.epineuro.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
    
}

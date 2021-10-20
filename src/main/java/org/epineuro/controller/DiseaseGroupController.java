package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.DiseaseGroupDTO;
import org.epineuro.service.DiseaseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/diseasegroup")
public class DiseaseGroupController {
    
    @Autowired
    private DiseaseGroupService service;

    @GetMapping
	public List<DiseaseGroupDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public DiseaseGroupDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

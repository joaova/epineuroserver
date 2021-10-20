package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.DiseaseDTO;
import org.epineuro.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/disease")
public class DiseaseController {
    
    @Autowired
    private DiseaseService service;

    @GetMapping
	public List<DiseaseDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public DiseaseDTO search(@PathVariable String id) {
		return service.buscar(id);
	}
}

package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.MedicationDTO;
import org.epineuro.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/medication")
public class MedicationController {
    
    @Autowired
    private MedicationService service;

    @GetMapping
	public List<MedicationDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public MedicationDTO search(@PathVariable String id) {
		return service.buscar(id);
	}
}

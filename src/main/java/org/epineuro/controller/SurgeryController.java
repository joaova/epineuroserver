package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.SurgeryDTO;
import org.epineuro.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/surgery")
public class SurgeryController {
    
    @Autowired
    private SurgeryService service;

    @GetMapping
	public List<SurgeryDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public SurgeryDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

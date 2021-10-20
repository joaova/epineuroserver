package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.ScholarityDTO;
import org.epineuro.service.ScholarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/scholarity")
public class ScholarityController {
    
    @Autowired
    private ScholarityService service;

    @GetMapping
	public List<ScholarityDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public ScholarityDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

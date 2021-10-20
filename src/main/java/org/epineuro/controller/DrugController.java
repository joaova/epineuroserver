package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.DrugsDTO;
import org.epineuro.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/drug")
public class DrugController {
    
    @Autowired
    private DrugService service;

    @GetMapping
	public List<DrugsDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public DrugsDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

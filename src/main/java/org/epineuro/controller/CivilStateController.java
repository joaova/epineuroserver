package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.CivilStateDTO;
import org.epineuro.service.CivilStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/civilstate")
public class CivilStateController {
    
    @Autowired
    private CivilStateService service;

    @GetMapping
	public List<CivilStateDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public CivilStateDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

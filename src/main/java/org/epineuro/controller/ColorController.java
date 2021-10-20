package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.ColorDTO;
import org.epineuro.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/color")
public class ColorController {
    
    @Autowired
    private ColorService service;

    @GetMapping
	public List<ColorDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public ColorDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

package org.epineuro.controller;

import java.util.List;

import org.epineuro.dto.ExamDTO;
import org.epineuro.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/exam")
public class ExamController {
    
    @Autowired
    private ExamService service;

    @GetMapping
	public List<ExamDTO> list() {
		return service.listar();
	}

    @GetMapping("/{id}")
	public ExamDTO search(@PathVariable Long id) {
		return service.buscar(id);
	}
}

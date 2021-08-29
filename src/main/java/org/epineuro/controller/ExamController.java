package org.epineuro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.epineuro.dto.ExamDTO;
import org.epineuro.request.ExamRequest;
import org.epineuro.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService service;
    
    @GetMapping
	public List<ExamDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid ExamRequest request) {
		ExamDTO exam = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(exam.getName()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExamDTO> buscar(@PathVariable String id) {
		ExamDTO exam = service.buscar(id);
		
		if (exam != null) {
			
			return ResponseEntity.ok().body(exam);
		}

		return ResponseEntity.notFound().build();	
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Void> atualizar(@RequestBody Disease obj, @PathVariable Long id) {
//		
//		DiseaseDTO diseaseAtual = service.buscar(id);
//		
//		if (diseaseAtual != null) {
//
//			obj.setId(id);
//			service.atualizar(obj);
//			
//			return ResponseEntity.noContent().build();
//		}
//
//		return ResponseEntity.notFound().build();
//				
//	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Disease> excluir(@PathVariable Long id) {
//		
//		service.excluir(id);
//		return ResponseEntity.noContent().build();
//
//	}

}

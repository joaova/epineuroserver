package org.epineuro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.epineuro.dto.DrugsDTO;
import org.epineuro.request.DrugsRequest;
import org.epineuro.service.DrugService;
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
@RequestMapping("/drugs")
public class DrugsController {
    
    @Autowired
    private DrugService service;
    
    @GetMapping
	public List<DrugsDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid DrugsRequest request) {
		DrugsDTO drug = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(drug.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DrugsDTO> buscar(@PathVariable Long id) {
		DrugsDTO drug = service.buscar(id);
		
		if (drug != null) {
			
			return ResponseEntity.ok().body(drug);
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

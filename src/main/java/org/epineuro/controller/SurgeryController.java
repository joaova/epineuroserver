package org.epineuro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.epineuro.dto.SurgeryDTO;
import org.epineuro.request.SurgeryRequest;
import org.epineuro.service.SurgeryService;
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
@RequestMapping("/surgery")
public class SurgeryController {
    
    @Autowired
    private SurgeryService service;
    
    @GetMapping
	public List<SurgeryDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid SurgeryRequest request) {
		SurgeryDTO surg = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(surg.getName()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SurgeryDTO> buscar(@PathVariable String id) {
		SurgeryDTO surg = service.buscar(id);
		
		if (surg != null) {
			
			return ResponseEntity.ok().body(surg);
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

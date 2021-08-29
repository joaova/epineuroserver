package org.epineuro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.epineuro.dto.MedicationDTO;
import org.epineuro.request.MedicationRequest;
import org.epineuro.service.MedicationService;
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
@RequestMapping("/medications")
public class MedicationController {
    
    @Autowired
    private MedicationService service;
    
    @GetMapping
	public List<MedicationDTO> listar() {
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid MedicationRequest request) {
		MedicationDTO med = service.salvar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(med.getName()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicationDTO> buscar(@PathVariable Long id) {
		MedicationDTO med = service.buscar(id);
		
		if (med != null) {
			
			return ResponseEntity.ok().body(med);
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

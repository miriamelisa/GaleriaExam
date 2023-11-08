package spring.galeria.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.galeria.model.ObrasDTO;
import spring.galeria.services.ObrasService;




@RestController
@RequestMapping("/obras")
public class ObrasRestController {
	@Autowired
	ObrasService obrasService;
	
	@PostMapping()
	public ResponseEntity<?> createObra(@RequestBody @Validated ObrasDTO obra){
		
		obrasService.createObra(obra);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obra.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllObras(){
		return ResponseEntity.ok(obrasService.getAllobras());
	}
	

}

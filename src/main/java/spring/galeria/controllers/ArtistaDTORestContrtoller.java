package spring.galeria.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.galeria.model.ArtistaDTO;
import spring.galeria.services.ArtistaService;


@RestController
@RequestMapping("/artistas")
public class ArtistaDTORestContrtoller {
	ArtistaService artistaservice;
	
	@GetMapping()
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(artistaservice.getAllartistas());
	}
	
	@PostMapping()
	public ResponseEntity<?> createArtista(@RequestBody @Validated ArtistaDTO artis){
		
		artistaservice.createArtista(artis);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(artis.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	
	
	

}

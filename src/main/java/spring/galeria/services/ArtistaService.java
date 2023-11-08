package spring.galeria.services;

import java.util.List;

import spring.galeria.model.ArtistaDTO;



public interface ArtistaService {
	
	ArtistaDTO getArtistaById(Integer id);
	
	List<ArtistaDTO> getAllartistas();
	
	void createArtista(ArtistaDTO artista);

}

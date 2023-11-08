package spring.galeria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.galeria.exceptions.ArtistasCreationException;

import spring.galeria.model.ArtistaDTO;



public class ArtistaServiceImpl implements ArtistaService {
	@Autowired
	ArtistaService artistassService;
	ArrayList<ArtistaDTO> artistas = new ArrayList<>();
	ArtistaDTO ar = new ArtistaDTO(1, "Goya");
	ArtistaDTO ar2 = new ArtistaDTO(2, "Picasso");
	ArtistaDTO ar3 = new ArtistaDTO(3, "Dalí");
	ArtistaDTO ar4 = new ArtistaDTO(4, "Miró");

	public ArtistaServiceImpl(){
	artistas.add(ar);
	artistas.add(ar2);
	artistas.add(ar3);
	artistas.add(ar4);

	}

	@Override
	public ArtistaDTO getArtistaById(Integer id) {
		for(ArtistaDTO a: artistas) {
			if(a.getId() == id) {			
				return a;
			}
		}
			throw new ArtistasCreationException("No existe el artista con el id: " + id);
	}

	@Override
	public List<ArtistaDTO> getAllartistas() {
		// TODO Auto-generated method stub
		return artistas;
	}

	@Override
	public void createArtista(ArtistaDTO artista) {
		// TODO Auto-generated method stub
		artistas.add(artista);
		
	}



	
	
}
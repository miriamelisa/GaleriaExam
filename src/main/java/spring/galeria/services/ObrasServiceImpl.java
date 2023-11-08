package spring.galeria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.galeria.exceptions.ObrasCreationException;
import spring.galeria.model.ObrasDTO;



public class ObrasServiceImpl implements ObrasService{
	@Autowired
	ObrasService obrasService;
	@Autowired
	ArtistaService artistassService;
	
	ArrayList<ObrasDTO> obras = new ArrayList<>();
	ObrasDTO ar = new ObrasDTO(1, "Titulo1", "hola soy la descripción uno", 1);
	ObrasDTO ar2 = new ObrasDTO(2, "Titulo2", "hola soy la descripción dos", 2);
	ObrasDTO ar3 = new ObrasDTO(3, "Titulo3", "hola soy la descripción tres", 1);
	ObrasDTO ar4 = new ObrasDTO(4,"Titulo4", "hola soy la descripción cuatro",3);
	

	public ObrasServiceImpl() {
		obras.add(ar);
		obras.add(ar2);
		obras.add(ar3);
		obras.add(ar4);
	}
//Lista con todas las obras
	@Override
	public List<ObrasDTO> getAllobras() {
		
		return obras;
	}
	//creacio nde nueva obra
@Override
	public void createObra(ObrasDTO obra) {
		obras.add(obra);
		
	}
//Buscar Obra por id
	@Override
	public ObrasDTO getLibroByid(Integer id) {
		for(ObrasDTO ob: obras) {
		if(ob.getId() == id) {			
			return ob;
		}
	}
		
		throw new ObrasCreationException("No existe una obra con el id: " + id);
}

	//String getDescription(Integer ObraId);
	//verificar si la descipcion es correcta si no emite exception
	@Override
	public String getDescription(String descripcion) {
		for (ObrasDTO o : obras) {
			if (o.getDescription() == descripcion) {
				return o.getDescription();
			}
		}
		throw new ObrasCreationException("La descripcion no corresponde");
	}

	//se puede añadir a nuevas otras si el artista q ingreso existe en artistas
	@Override
	public List<ObrasDTO> getAllartistas(Integer artistaId) {
		ArrayList<ObrasDTO> obrasnew = new ArrayList<>();

		for (ObrasDTO re : obrasnew) {
			if (re.getArtistaId() == artistaId) {
				obrasnew.add(re);
			}
		}

		if (obrasnew.isEmpty()) {
			throw new ObrasCreationException(
					"No se puede crear la obra porque el artista con el id " + artistaId + "no se encuentra");
		}

		return obrasnew;
	}
	
	
	

}

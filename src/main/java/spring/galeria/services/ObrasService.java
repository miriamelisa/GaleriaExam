package spring.galeria.services;

import java.util.List;

import spring.galeria.model.ObrasDTO;

public interface ObrasService {
	
	List<ObrasDTO> getAllobras();
	
	void createObra(ObrasDTO obra);
	
	ObrasDTO getLibroByid(Integer id );
	
	String getDescription(String descripcion);
	
	//necesitpo la creacion de una obra obras  con ciertos artistas con artistas
	List<ObrasDTO> getAllartistas(Integer artistaId);
	
	
	
}

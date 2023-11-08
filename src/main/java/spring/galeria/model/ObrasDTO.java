package spring.galeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.galeria.validators.DescripcionValidator;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObrasDTO {

	private Integer id;
	private String title;
	@DescripcionValidator
	private String description;
	private Integer artistaId;
	
	

}

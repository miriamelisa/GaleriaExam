package spring.galeria.validators;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DescripcionValid implements ConstraintValidator<DescripcionValidator,String>{
	// es strign es el tipo de dato q yo voy a bvalidar como voy a validar un string pues coloco String

	
	@Override
	public void initialize(DescripcionValidator constraintAnnotation) {}
	//logica de validacion 
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (value == null || value.trim().isEmpty()) {
			return false;
			}
			String[] palabras = value.trim().split("\\s+");
			return palabras.length >= 5;
	}
}
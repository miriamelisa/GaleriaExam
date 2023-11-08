package spring.galeria.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring.galeria.exceptions.ArtistasCreationException;
import spring.galeria.exceptions.ObrasCreationException;



@RestControllerAdvice
public class GlobalHanldlerException {
	@ExceptionHandler( ArtistasCreationException.class )
	public ProblemDetail handleBookNotFoundException(ArtistasCreationException e) {

		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Artistas Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Artistas");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}

		@ExceptionHandler( ObrasCreationException.class )
		public ProblemDetail handleObrasCreationException(ObrasCreationException e) {
			
			ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
			problemDetail.setTitle("Artistas Exception Occurred");
			problemDetail.setType(URI.create("http://cesurformacion.com"));
			problemDetail.setProperty("errorCategory", "Artistas");
			problemDetail.setProperty("timeStamp", Instant.now());

			return problemDetail;
		}
	
	

}

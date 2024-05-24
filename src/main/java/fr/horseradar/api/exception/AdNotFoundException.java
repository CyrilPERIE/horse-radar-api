package fr.horseradar.api.exception;

public class AdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2411342860015175130L;

	public AdNotFoundException(Long id) {
	    super("Annonce id/" + id + " non trouvée!");
	  }
	
}

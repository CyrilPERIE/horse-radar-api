package fr.horseradar.api.exception;

public class HorseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5983875206271829392L;

	public HorseNotFoundException(Long id) {
	    super("Cheval id/" + id + " non trouvé!");
	  }
	
}

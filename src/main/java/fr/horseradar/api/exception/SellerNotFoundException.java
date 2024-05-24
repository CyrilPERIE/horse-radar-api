package fr.horseradar.api.exception;

public class SellerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -502761013104026672L;

	public SellerNotFoundException(Long id) {
	    super("Vendeur id/" + id + " non trouvé!");
	  }
	
}

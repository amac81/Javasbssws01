package pt.bitclinic.javasbssws01.services.exceptions;

//errors can be generated by domain entities

//this class can extend RuntimeException or Exception
//the difference is that Exception forces the programmer to handle the exception
//on the other hand, the RuntimeException class can help the user to handle other exceptions that occur (for example: the user types a letter in the input instead of a number)

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}

}
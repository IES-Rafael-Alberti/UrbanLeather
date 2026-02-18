package backend.error.excepciones;

public class PeticionIncorrectaException extends RuntimeException {
    public PeticionIncorrectaException(String message) {
        super(message);
    }
}

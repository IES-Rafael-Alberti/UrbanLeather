package backend.error.excepciones;

public class DuplicadoException extends RuntimeException {
    public DuplicadoException(String message) {
        super(message);
    }
}

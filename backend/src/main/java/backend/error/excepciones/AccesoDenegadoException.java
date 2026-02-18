package backend.error.excepciones;

public class AccesoDenegadoException extends RuntimeException {
  public AccesoDenegadoException(String message) {
    super(message);
  }
}

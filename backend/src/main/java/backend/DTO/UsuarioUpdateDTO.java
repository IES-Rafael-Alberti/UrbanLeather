package backend.DTO;

public class UsuarioUpdateDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String username;

    public UsuarioUpdateDTO() {}

    public UsuarioUpdateDTO(String nombre, String apellido, String email,  String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

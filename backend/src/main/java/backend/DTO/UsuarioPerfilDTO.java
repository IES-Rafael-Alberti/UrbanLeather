package backend.DTO;

public class UsuarioPerfilDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String roles;

    public UsuarioPerfilDTO() {}

    public UsuarioPerfilDTO(String nombre, String apellido, String email, String username, String roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
package backend.DTO;

public class DireccionRegisterDTO {
    private String calle;
    private int numero;
    private String cp;
    private String provincia;
    private String municipio;

    public DireccionRegisterDTO() {}

    public DireccionRegisterDTO(String calle, int numero, String cp, String provincia, String municipio) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.provincia = provincia;
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCp() {
        return cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

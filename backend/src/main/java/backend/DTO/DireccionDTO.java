package backend.DTO;

public class DireccionDTO {

    private String calle;
    private int numero;
    private String cp;
    private String provincia;
    private String municipio;

    public DireccionDTO() {}

    public DireccionDTO(String calle, int numero, String cp, String provincia, String municipio) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.provincia = provincia;
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

package backend.DTO;

import java.util.List;

public class CarritoDTO {

    private String username;
    private List<CarritoItemDTO> items;

    public CarritoDTO() {}

    public CarritoDTO(String username, List<CarritoItemDTO> items) {
        this.username = username;
        this.items = items;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CarritoItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CarritoItemDTO> items) {
        this.items = items;
    }
}

package backend.controller;

import backend.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito/item")
public class CarritoItemController {

    @Autowired
    private CarritoItemService carritoItemService;


    @PostMapping("/add")
    public ResponseEntity<String> addItem(
            @RequestParam Long productoId,
            @RequestParam Long tallaId,
            @RequestParam int cantidad
    ) {

        String username =
                SecurityContextHolder.getContext().getAuthentication().getName();

        carritoItemService.addItem(username, productoId, tallaId, cantidad);

        return ResponseEntity.ok("Producto añadido al carrito");
    }


    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> eliminarItem(@PathVariable Long itemId) {

        carritoItemService.eliminarItem(itemId);

        return ResponseEntity.ok("Item eliminado del carrito");
    }


    @PutMapping("/{itemId}")
    public ResponseEntity<String> actualizarCantidad(
            @PathVariable Long itemId,
            @RequestParam int cantidad
    ) {

        carritoItemService.actualizarCantidad(itemId, cantidad);

        return ResponseEntity.ok("Cantidad actualizada");
    }
}
package backend.controller;

import backend.DTO.CarritoDTO;
import backend.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;


    @GetMapping
    public ResponseEntity<CarritoDTO> verCarrito() {

        String username =
                SecurityContextHolder.getContext().getAuthentication().getName();

        return ResponseEntity.ok(carritoService.verCarrito(username));
    }


    @DeleteMapping("/vaciar")
    public ResponseEntity<String> vaciarCarrito() {

        String username =
                SecurityContextHolder.getContext().getAuthentication().getName();

        carritoService.vaciarCarrito(username);

        return ResponseEntity.ok("Carrito vaciado");
    }
}
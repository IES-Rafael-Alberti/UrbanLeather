package backend.controller;

import backend.DTO.DireccionAdminDTO;
import backend.DTO.DireccionDTO;
import backend.DTO.DireccionRegisterDTO;
import backend.model.Direccion;
import backend.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class DireccionController {

    @Autowired
    private DireccionService direccionService;


    @PostMapping("/direccionRegister")
    public ResponseEntity<String> register(@RequestBody DireccionAdminDTO dto) {

        direccionService.registerDireccion(dto);

        return ResponseEntity.ok(
                "Dirección registrada correctamente para el usuario " + dto.getUserName()
        );
    }


    @PutMapping("/direccionUpdate")
    public ResponseEntity<String> actualizar(@RequestBody DireccionAdminDTO dto) {

        direccionService.actualizarDireccion(dto);

        return ResponseEntity.ok(
                "Dirección del usuario " + dto.getUserName() + " actualizada correctamente"
        );
    }


    @DeleteMapping("/eliminarDireccion/{username}")
    public ResponseEntity<String> eliminar(@PathVariable String username) {

        direccionService.eliminarDireccion(username);

        return ResponseEntity.ok("Dirección eliminada correctamente");
    }


    @PostMapping("/registerMiDireccion")
    public ResponseEntity<String> registerMiDireccion(@RequestBody DireccionRegisterDTO dto) {

        direccionService.registerMiDireccion(dto);

        return ResponseEntity.ok("Dirección registrada correctamente");
    }


    @PutMapping("/updateMiDireccion")
    public ResponseEntity<String> actualizarMiDireccion(@RequestBody DireccionRegisterDTO dto) {

        direccionService.actualizarMiDireccion(dto);

        return ResponseEntity.ok("Dirección actualizada correctamente");
    }


    @DeleteMapping("/deleteMiDireccion")
    public ResponseEntity<String> eliminarMiDireccion() {

        direccionService.eliminarMiDireccion();

        return ResponseEntity.ok("Dirección eliminada correctamente");
    }

    @GetMapping("/miDireccion")
    public ResponseEntity<DireccionDTO> obtenerDireccion(
            Authentication auth,
            @RequestParam(required = false) String username) {

        if (username != null && !username.isBlank()) {
            return ResponseEntity.ok(
                    direccionService.obtenerDireccion(username)
            );
        }

        return ResponseEntity.ok(
                direccionService.obtenerDireccion(auth.getName())
        );
    }
}
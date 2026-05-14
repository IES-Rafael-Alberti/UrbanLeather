package backend.controller;

import backend.DTO.UsuarioLoginDTO;
import backend.DTO.UsuarioPerfilDTO;
import backend.DTO.UsuarioRegisterDTO;
import backend.DTO.UsuarioUpdateDTO;
import backend.model.Usuario;
import backend.service.UsuarioService;
import backend.service.TokenService;
import backend.error.excepciones.PeticionIncorrectaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLoginDTO dto) {

        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new PeticionIncorrectaException("El username es obligatorio.");
        }

        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new PeticionIncorrectaException("El password es obligatorio.");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        String token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuarioRegisterDTO dto) {

        if (dto.getNombre() == null || dto.getNombre().isEmpty())
            throw new PeticionIncorrectaException("El nombre es obligatorio.");

        if (dto.getApellido() == null || dto.getApellido().isEmpty())
            throw new PeticionIncorrectaException("El apellido es obligatorio.");

        if (dto.getEmail() == null || dto.getEmail().isEmpty())
            throw new PeticionIncorrectaException("El email es obligatorio.");

        if (dto.getUsername() == null || dto.getUsername().isEmpty())
            throw new PeticionIncorrectaException("El username es obligatorio.");

        if (dto.getPassword() == null || dto.getPassword().isEmpty())
            throw new PeticionIncorrectaException("El password es obligatorio.");

        if (dto.getRepetirPassword() == null || dto.getRepetirPassword().isEmpty())
            throw new PeticionIncorrectaException("Repetir password es obligatorio.");

        usuarioService.register(dto);

        return ResponseEntity.ok("Usuario creado correctamente: " + dto.getUsername());
    }

    @PutMapping("/usuarioUpdate")
    public ResponseEntity<String> actualizarUsuario(@RequestBody UsuarioUpdateDTO dto) {

        usuarioService.actualizarUsuario(dto);

        return ResponseEntity.ok("Usuario actualizado: " + dto.getUsername());
    }

    @DeleteMapping("/usuarioDelete/{username}")
    public ResponseEntity<String> borrarUsuario(@PathVariable String username) {

        usuarioService.borrarUsuario(username);

        return ResponseEntity.ok("Usuario eliminado: " + username);
    }

    @DeleteMapping("/borrarMiCuenta")
    public ResponseEntity<String> borrarMiCuenta() {

        String usernameActual =
                SecurityContextHolder.getContext().getAuthentication().getName();

        usuarioService.borrarMiCuenta(usernameActual, usernameActual);

        return ResponseEntity.ok("Cuenta eliminada correctamente");
    }

    @PutMapping("/updateMiPerfil")
    public ResponseEntity<String> actualizarMiPerfil(@RequestBody UsuarioUpdateDTO dto) {

        String usernameActual =
                SecurityContextHolder.getContext().getAuthentication().getName();

        usuarioService.actualizarMiPerfil(usernameActual, dto);

        return ResponseEntity.ok("Perfil actualizado correctamente");
    }

    @GetMapping("/miPerfil")
    public UsuarioPerfilDTO getPerfil(
            Authentication auth,
            @RequestParam(required = false) String username) {

        // ADMIN
        if (username != null && !username.isBlank()) {
            return usuarioService.obtenerPerfil(username);
        }

        // usuario logueado
        return usuarioService.obtenerPerfil(auth.getName());
    }
}
package backend.service;

import backend.DTO.UsuarioPerfilDTO;
import backend.DTO.UsuarioRegisterDTO;
import backend.DTO.UsuarioUpdateDTO;
import backend.error.excepciones.DuplicadoException;
import backend.error.excepciones.NoEncontradoException;
import backend.error.excepciones.PeticionIncorrectaException;
import backend.model.Usuario;
import backend.model.Usuario.Roles;
import backend.model.Direccion;
import backend.model.Compra;
import backend.repository.UsuarioRepository;
import backend.repository.DireccionRepository;
import backend.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        GrantedAuthority authority =
                new SimpleGrantedAuthority("ROLE_" + usuario.getRoles().name());

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(List.of(authority))
                .build();
    }

    public boolean register(UsuarioRegisterDTO dto) {

        if (usuarioRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new DuplicadoException("El usuario ya existe");
        }

        if (!dto.getPassword().equals(dto.getRepetirPassword())) {
            throw new PeticionIncorrectaException("Las contraseñas no coinciden");
        }

        Roles roleEnum;
        try {
            roleEnum = Roles.valueOf(dto.getRoles().toUpperCase());
        } catch (Exception e) {
            roleEnum = Roles.USER;
        }

        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        Usuario usuario = new Usuario(
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getUsername(),
                hashedPassword,
                roleEnum
        );

        usuarioRepository.save(usuario);
        return true;
    }

    public UsuarioUpdateDTO actualizarUsuario(UsuarioUpdateDTO dto) {

        Usuario usuario = usuarioRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));

        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());

        usuarioRepository.save(usuario);

        return dto;
    }

    public boolean borrarUsuario(String username) {

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));

        Optional<Direccion> direccion =
                direccionRepository.findByUsuarioUsername(username);

        direccion.ifPresent(direccionRepository::delete);

        List<Compra> compras =
                compraRepository.findByUsuarioUsername(username);

        if (compras != null && !compras.isEmpty()) {
            compraRepository.deleteAll(compras);
        }

        usuarioRepository.delete(usuario);
        return true;
    }

    public boolean borrarMiCuenta(String authUser, String username) {

        if (!authUser.equals(username)) {
            throw new RuntimeException("No puedes borrar otra cuenta");
        }

        return borrarUsuario(username);
    }

    public UsuarioUpdateDTO actualizarMiPerfil(String authUser, UsuarioUpdateDTO dto) {

        if (!authUser.equals(dto.getUsername())) {
            throw new RuntimeException("No puedes modificar otro usuario");
        }

        return actualizarUsuario(dto);
    }

    public UsuarioPerfilDTO obtenerPerfil(String username) {

        Usuario u = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));

        return new UsuarioPerfilDTO(
                u.getNombre(),
                u.getApellido(),
                u.getEmail(),
                u.getUsername(),
                u.getRoles().name()
        );
    }
}
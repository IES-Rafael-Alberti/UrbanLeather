package backend.service;

import backend.DTO.DireccionRegisterDTO;
import backend.DTO.DireccionAdminDTO;
import backend.DTO.DireccionDTO;
import backend.error.excepciones.DuplicadoException;
import backend.error.excepciones.NoEncontradoException;
import backend.error.excepciones.PeticionIncorrectaException;
import backend.model.Direccion;
import backend.model.Usuario;
import backend.repository.DireccionRepository;
import backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean registerDireccion(DireccionAdminDTO dto) {

        validar(dto.getNumero(), dto.getCp(), dto.getProvincia(), dto.getMunicipio());

        Usuario usuario = usuarioRepository.findByUsername(dto.getUserName())
                .orElseThrow(() -> new NoEncontradoException("Ese usuario no existe"));

        Optional<Direccion> existente =
                direccionRepository.findByUsuarioUsername(dto.getUserName());

        if (existente.isPresent()) {
            throw new DuplicadoException("Ya existe una dirección para este usuario");
        }

        Direccion direccion = new Direccion(
                dto.getCalle(),
                dto.getNumero(),
                dto.getCp(),
                dto.getProvincia(),
                dto.getMunicipio(),
                usuario
        );

        direccionRepository.save(direccion);

        return true;
    }


    public DireccionAdminDTO actualizarDireccion(DireccionAdminDTO dto) {

        validar(dto.getNumero(), dto.getCp(), dto.getProvincia(), dto.getMunicipio());

        Direccion direccion = direccionRepository.findByUsuarioUsername(dto.getUserName())
                .orElseThrow(() -> new NoEncontradoException("No existe dirección"));

        direccion.setCalle(dto.getCalle());
        direccion.setNumero(dto.getNumero());
        direccion.setCp(dto.getCp());
        direccion.setProvincia(dto.getProvincia());
        direccion.setMunicipio(dto.getMunicipio());

        direccionRepository.save(direccion);

        return new DireccionAdminDTO(
                dto.getCalle(),
                dto.getNumero(),
                dto.getCp(),
                dto.getProvincia(),
                dto.getMunicipio(),
                dto.getUserName()
        );
    }


    public boolean eliminarDireccion(String username) {

        Direccion direccion = direccionRepository.findByUsuarioUsername(username)
                .orElseThrow(() -> new NoEncontradoException("No existe una dirección"));

        direccionRepository.delete(direccion);

        return true;
    }


    public boolean registerMiDireccion(DireccionRegisterDTO dto) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new NoEncontradoException("Usuario no existe"));

        validar(dto.getNumero(), dto.getCp(), dto.getProvincia(), dto.getMunicipio());

        Optional<Direccion> existente =
                direccionRepository.findByUsuarioUsername(username);

        if (existente.isPresent()) {
            throw new DuplicadoException("Ya existe una dirección para este usuario");
        }

        Direccion direccion = new Direccion(
                dto.getCalle(),
                dto.getNumero(),
                dto.getCp(),
                dto.getProvincia(),
                dto.getMunicipio(),
                usuario
        );

        direccionRepository.save(direccion);

        return true;
    }


    public DireccionRegisterDTO actualizarMiDireccion(DireccionRegisterDTO dto) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Direccion direccion = direccionRepository.findByUsuarioUsername(username)
                .orElseThrow(() -> new NoEncontradoException("No existe dirección"));

        validar(dto.getNumero(), dto.getCp(), dto.getProvincia(), dto.getMunicipio());

        direccion.setCalle(dto.getCalle());
        direccion.setNumero(dto.getNumero());
        direccion.setCp(dto.getCp());
        direccion.setProvincia(dto.getProvincia());
        direccion.setMunicipio(dto.getMunicipio());

        direccionRepository.save(direccion);

        return dto;
    }


    public boolean eliminarMiDireccion() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Direccion direccion = direccionRepository.findByUsuarioUsername(username)
                .orElseThrow(() -> new NoEncontradoException("No existe dirección"));

        direccionRepository.delete(direccion);

        return true;
    }


    public DireccionDTO obtenerMiDireccion() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Direccion d = direccionRepository.findByUsuarioUsername(username)
                .orElseThrow(() -> new NoEncontradoException("No existe dirección"));

        return new DireccionDTO(
                d.getCalle(),
                d.getNumero(),
                d.getCp(),
                d.getProvincia(),
                d.getMunicipio()
        );
    }

    public DireccionDTO obtenerDireccion(String username) {

        Direccion d = direccionRepository.findByUsuarioUsername(username)
                .orElseThrow(() -> new NoEncontradoException("No existe dirección"));

        return new DireccionDTO(
                d.getCalle(),
                d.getNumero(),
                d.getCp(),
                d.getProvincia(),
                d.getMunicipio()
        );
    }


    private void validar(int numero, String cp, String provincia, String municipio) {

        if (numero <= 0) {
            throw new PeticionIncorrectaException("El número debe ser mayor a 0");
        }

        if (cp == null || cp.length() != 5) {
            throw new PeticionIncorrectaException("El CP debe de tener 5 dígitos");
        }

        if (provincia == null || provincia.isEmpty()) {
            throw new PeticionIncorrectaException("La provincia es obligatoria");
        }

        if (municipio == null || municipio.isEmpty()) {
            throw new PeticionIncorrectaException("El municipio es obligatorio");
        }
    }
}
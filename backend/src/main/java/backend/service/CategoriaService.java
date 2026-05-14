package backend.service;

import backend.DTO.CategoriaDTO;
import backend.error.excepciones.NoEncontradoException;
import backend.error.excepciones.PeticionIncorrectaException;
import backend.model.Categoria;
import backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public boolean crearCategoria(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new PeticionIncorrectaException("El nombre es obligatorio");
        }

        Categoria categoria = new Categoria(nombre);

        categoriaRepository.save(categoria);

        return true;
    }


    public List<CategoriaDTO> listarCategorias() {

        return categoriaRepository.findAll()
                .stream()
                .map(c -> new CategoriaDTO(
                        c.getId(),
                        c.getNombre()
                ))
                .collect(Collectors.toList());
    }


    public boolean actualizarCategoria(Long id, String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new PeticionIncorrectaException("El nombre es obligatorio");
        }

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoEncontradoException("Categoría no encontrada"));

        categoria.setNombre(nombre);

        categoriaRepository.save(categoria);

        return true;
    }


    public boolean eliminarCategoria(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoEncontradoException("Categoría no encontrada"));

        categoriaRepository.delete(categoria);

        return true;
    }
}

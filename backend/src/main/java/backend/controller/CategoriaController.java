package backend.controller;

import backend.DTO.CategoriaDTO;
import backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping("/categoriaRegister")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaDTO dto) {

        categoriaService.crearCategoria(dto.getNombre());

        return ResponseEntity.ok("Categoría creada correctamente");
    }


    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {

        return ResponseEntity.ok(categoriaService.listarCategorias());
    }


    @PutMapping("/categoriaUpdate/{id}")
    public ResponseEntity<String> actualizarCategoria(
            @PathVariable Long id,
            @RequestParam String nombre
    ) {

        categoriaService.actualizarCategoria(id, nombre);

        return ResponseEntity.ok("Categoría actualizada correctamente");
    }


    @DeleteMapping("/categoriaDelete/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) {

        categoriaService.eliminarCategoria(id);

        return ResponseEntity.ok("Categoría eliminada correctamente");
    }
}

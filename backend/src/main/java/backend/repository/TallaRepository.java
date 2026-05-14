package backend.repository;

import backend.model.Talla;
import backend.model.Talla.TallaNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long> {

    List<Talla> findByProductoId(Long productoId);

    Optional<Talla> findByProductoIdAndNombre(Long productoId, TallaNombre nombre);
}
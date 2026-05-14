package backend.repository;

import backend.model.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {

    List<CarritoItem> findByCarritoId(Long carritoId);

    List<CarritoItem> findByCarritoUsuarioUsername(String username);

    Optional<CarritoItem> findByCarritoIdAndProductoIdAndTallaId(
            Long carritoId,
            Long productoId,
            Long tallaId
    );
}

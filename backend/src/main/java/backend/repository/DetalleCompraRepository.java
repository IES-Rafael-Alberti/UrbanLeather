package backend.repository;

import backend.model.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

    List<DetalleCompra> findByCompra_Id(Long compraId);

    List<DetalleCompra> findByProducto_Id(Long productoId);

    List<DetalleCompra> findByCompra_Usuario_Username(String username);
}

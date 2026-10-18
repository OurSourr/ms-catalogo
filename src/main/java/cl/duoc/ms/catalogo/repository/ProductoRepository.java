package cl.duoc.ms.catalogo.repository;

import cl.duoc.ms.catalogo.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    List<ProductoEntity> findByActivoTrue();
}
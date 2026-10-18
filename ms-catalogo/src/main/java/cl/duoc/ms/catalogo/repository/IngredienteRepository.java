package cl.duoc.ms.catalogo.repository;

import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;
import cl.duoc.ms.catalogo.entity.IngredienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
    @Repository
public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Integer> {
    List<IngredienteEntity> findByActivoTrue();
    List<IngredienteEntity> findByCategoriaAndActivoTrue(CategoriaIngrediente categoria);
}

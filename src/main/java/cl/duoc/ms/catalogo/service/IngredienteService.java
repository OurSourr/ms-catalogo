package cl.duoc.ms.catalogo.service;

import cl.duoc.ms.catalogo.dto.IngredienteRequest;
import cl.duoc.ms.catalogo.dto.IngredienteResponse;
import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;
import cl.duoc.ms.catalogo.entity.IngredienteEntity;
import cl.duoc.ms.catalogo.repository.IngredienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Transactional(readOnly = true)
    public List<IngredienteResponse> obtenerTodosActivos() {
        return ingredienteRepository.findByActivoTrue().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<IngredienteResponse> obtenerPorCategoria(CategoriaIngrediente categoria) {
        return ingredienteRepository.findByCategoriaAndActivoTrue(categoria).stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public IngredienteResponse crearIngrediente(IngredienteRequest request) {
        IngredienteEntity entity = IngredienteEntity.builder()
                .nombre(request.getNombre())
                .categoria(request.getCategoria())
                .activo(request.getActivo() != null ? request.getActivo() : true)
                .build();

        IngredienteEntity guardado = ingredienteRepository.save(entity);
        return mapearAResponse(guardado);
    }

    private IngredienteResponse mapearAResponse(IngredienteEntity entity) {
        return IngredienteResponse.builder()
                .idIngrediente(entity.getId())
                .nombre(entity.getNombre())
                .categoria(entity.getCategoria())
                .activo(entity.getActivo())
                .build();
    }
}
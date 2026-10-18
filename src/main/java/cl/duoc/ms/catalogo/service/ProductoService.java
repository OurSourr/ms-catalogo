package cl.duoc.ms.catalogo.service;

import cl.duoc.ms.catalogo.dto.ProductoRequest;
import cl.duoc.ms.catalogo.dto.ProductoResponse;
import cl.duoc.ms.catalogo.entity.ProductoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.duoc.ms.catalogo.repository.ProductoRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductoResponse> obtenerTodosActivos() {
        return productoRepository.findByActivoTrue().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductoResponse obtenerPorId(Integer id) {
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
        return mapearAResponse(producto);
    }

    @Transactional
    public ProductoResponse crearProducto(ProductoRequest request) {
        ProductoEntity entity = ProductoEntity.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .stock(request.getStock())
                .activo(request.getActivo() != null ? request.getActivo() : true)
                .build();

        ProductoEntity guardado = productoRepository.save(entity);
        return mapearAResponse(guardado);
    }

    @Transactional
    public void descontarStock(Integer id, Integer cantidad) {
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
        }

        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }

    private ProductoResponse mapearAResponse(ProductoEntity entity) {
        return ProductoResponse.builder()
                .idProducto(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .stock(entity.getStock())
                .activo(entity.getActivo())
                .build();
    }
}
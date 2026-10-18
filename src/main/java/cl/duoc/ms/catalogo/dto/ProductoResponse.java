package cl.duoc.ms.catalogo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductoResponse {

    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Boolean activo;

    @Builder
    public ProductoResponse(Integer idProducto, String nombre, String descripcion, BigDecimal precio, Integer stock, Boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.activo = activo;
    }
}
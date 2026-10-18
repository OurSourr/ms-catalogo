package cl.duoc.ms.catalogo.dto;

import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredienteResponse {

    private Integer idIngrediente;
    private String nombre;
    private CategoriaIngrediente categoria;
    private Boolean activo;

    @Builder
    public IngredienteResponse(Integer idIngrediente, String nombre, CategoriaIngrediente categoria, Boolean activo) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.categoria = categoria;
        this.activo = activo;
    }
}
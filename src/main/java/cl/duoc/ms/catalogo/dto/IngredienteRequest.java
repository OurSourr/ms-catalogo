package cl.duoc.ms.catalogo.dto;
import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class IngredienteRequest {

    private String nombre;
    private CategoriaIngrediente categoria;
    private Boolean activo;

    @Builder
    public IngredienteRequest(String nombre, CategoriaIngrediente categoria, Boolean activo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.activo = activo;
    }
}
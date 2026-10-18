package cl.duoc.ms.catalogo.entity;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "ingredientes")
public class IngredienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CategoriaIngrediente categoria;

    @Column(nullable = false)
    private Boolean activo = true;

    public IngredienteEntity() {
    }

    @Builder
    public IngredienteEntity(Integer id, String nombre, CategoriaIngrediente categoria, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.activo = activo != null ? activo : true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaIngrediente getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaIngrediente categoria) {
        this.categoria = categoria;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
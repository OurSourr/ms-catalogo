package cl.duoc.ms.catalogo.config;


import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;
import cl.duoc.ms.catalogo.entity.IngredienteEntity;
import cl.duoc.ms.catalogo.entity.ProductoEntity;
import cl.duoc.ms.catalogo.repository.IngredienteRepository;
import cl.duoc.ms.catalogo.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final IngredienteRepository ingredienteRepository;

    public DataLoader(ProductoRepository productoRepository, IngredienteRepository ingredienteRepository) {
        this.productoRepository = productoRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.count() == 0) {
            ProductoEntity p1 = ProductoEntity.builder()
                    .nombre("Sour Tradicional 1L")
                    .descripcion("Base concentrada de limón natural para Pisco Sour perfecto.")
                    .precio(new BigDecimal("8990"))
                    .stock(50)
                    .activo(true)
                    .build();

            ProductoEntity p2 = ProductoEntity.builder()
                    .nombre("Sour Maracuyá 1L")
                    .descripcion("Mezcla tropical de maracuyá y limón para cócteles y mocktails.")
                    .precio(new BigDecimal("9990"))
                    .stock(30)
                    .activo(true)
                    .build();

            productoRepository.saveAll(List.of(p1, p2));
        }

        if (ingredienteRepository.count() == 0) {
            IngredienteEntity i1 = IngredienteEntity.builder().nombre("Gin").categoria(CategoriaIngrediente.DESTILADO).build();
            IngredienteEntity i2 = IngredienteEntity.builder().nombre("Pisco").categoria(CategoriaIngrediente.DESTILADO).build();
            IngredienteEntity i3 = IngredienteEntity.builder().nombre("Vodka").categoria(CategoriaIngrediente.DESTILADO).build();
            IngredienteEntity i4 = IngredienteEntity.builder().nombre("Limón").categoria(CategoriaIngrediente.FRUTA).build();
            IngredienteEntity i5 = IngredienteEntity.builder().nombre("Tónica").categoria(CategoriaIngrediente.MIXER).build();
            IngredienteEntity i6 = IngredienteEntity.builder().nombre("Hielo").categoria(CategoriaIngrediente.OTRO).build();

            ingredienteRepository.saveAll(List.of(i1, i2, i3, i4, i5, i6));
            System.out.println(">>> [ms-catalogo] Datos de Productos e Ingredientes cargados con éxito.");
        }
    }
}
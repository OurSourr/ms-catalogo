package cl.duoc.ms.catalogo.controller;


import cl.duoc.ms.catalogo.dto.IngredienteRequest;
import cl.duoc.ms.catalogo.dto.IngredienteResponse;
import cl.duoc.ms.catalogo.entity.CategoriaIngrediente;
import cl.duoc.ms.catalogo.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    public ResponseEntity<List<IngredienteResponse>> listarIngredientes(@RequestParam(required = false) CategoriaIngrediente categoria) {
        if (categoria != null) {
            return ResponseEntity.ok(ingredienteService.obtenerPorCategoria(categoria));
        }
        return ResponseEntity.ok(ingredienteService.obtenerTodosActivos());
    }

    @PostMapping
    public ResponseEntity<IngredienteResponse> crearIngrediente(@RequestBody IngredienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteService.crearIngrediente(request));
    }
}
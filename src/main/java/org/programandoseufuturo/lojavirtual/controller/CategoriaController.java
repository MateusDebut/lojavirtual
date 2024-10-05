package org.programandoseufuturo.lojavirtual.controller;

import java.util.List;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.programandoseufuturo.lojavirtual.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    private CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(service.obterCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.obterPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED.value())
            .body(service.cadastrar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.deletar(id));
    }

}

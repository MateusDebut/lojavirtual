package org.programandoseufuturo.lojavirtual.controller;

import java.util.List;

import org.programandoseufuturo.lojavirtual.model.Produto;
import org.programandoseufuturo.lojavirtual.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    private ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtos = service.obterTodosProdutos();
        return ResponseEntity.status(HttpStatus.OK.value()).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") int id) {
        return ResponseEntity
            .status(HttpStatus.OK.value()).body(service.obterProdutoPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto produtoCadastrado = service.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(produtoCadastrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK.value())
            .body(service.deletarProduto(id));
    }

}

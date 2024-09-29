package org.programandoseufuturo.lojavirtual.service;

import java.util.List;
import java.util.Optional;

import org.programandoseufuturo.lojavirtual.model.Produto;
import org.programandoseufuturo.lojavirtual.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> obterTodosProdutos() {
        return repository.findAll();
    }

    public Produto obterProdutoPeloId(int id) {
        Optional<Produto> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public Produto cadastrarProduto(Produto produto) {
        return repository.save(produto);
    }

    public Produto deletarProduto(int id) {
        Optional<Produto> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return optional.get();
        }
        throw new RuntimeException("Produto não encontrado");
    }

}

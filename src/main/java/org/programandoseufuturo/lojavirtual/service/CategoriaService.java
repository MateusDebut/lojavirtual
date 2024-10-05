package org.programandoseufuturo.lojavirtual.service;

import java.util.List;
import java.util.Optional;
import java.util.Optional;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.programandoseufuturo.lojavirtual.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> obterCategorias() {
        return repository.findAll();
    }

    public Categoria obterPeloId(int id) {
        Optional<Categoria> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("A categoria não foi encontrada");
    }

    public Categoria cadastrar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria deletar(int id) {
        Optional<Categoria> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return optional.get();
        }
        throw new RuntimeException("A categoria não foi encontrada");
    }

}

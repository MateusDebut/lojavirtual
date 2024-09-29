package org.programandoseufuturo.lojavirtual.repository;

import java.util.List;

import org.programandoseufuturo.lojavirtual.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByEstaFavoritadoTrue();
    List<Produto> findByEstaDisponivelTrue();
}

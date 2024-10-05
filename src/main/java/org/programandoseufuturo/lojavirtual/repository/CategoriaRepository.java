package org.programandoseufuturo.lojavirtual.repository;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

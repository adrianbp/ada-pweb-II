package com.ada.aula.web.projetoprogramacaowebdois.repository;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    @Query(value="SELECT p FROM Livro p WHERE p.categoriaId = :id ")
    List<Livro> findByCategoria(@Param("id") Categoria categoria);

    @Query(value="SELECT p FROM Livro p WHERE p.editoraId = :id ")
    List<Livro> findByEditora(@Param("id") Editora editora);
}

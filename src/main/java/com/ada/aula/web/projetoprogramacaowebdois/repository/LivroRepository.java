package com.ada.aula.web.projetoprogramacaowebdois.repository;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    List<Livro> findByCategoriaId(Long id);

    List<Livro> findByEditoraId(Long id);
}

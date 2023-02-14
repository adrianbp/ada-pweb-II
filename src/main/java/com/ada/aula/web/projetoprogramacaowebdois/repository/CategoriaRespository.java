package com.ada.aula.web.projetoprogramacaowebdois.repository;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRespository extends JpaRepository<Categoria,Long> {
}

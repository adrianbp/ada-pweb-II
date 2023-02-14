package com.ada.aula.web.projetoprogramacaowebdois.repository;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora,Long> {
}

package com.ada.aula.web.projetoprogramacaowebdois.service;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;


import java.util.List;

public interface LivroService extends BaseService<LivroDTO> {

    List<LivroDTO> buscaPorCategoria(Long id);

    List<LivroDTO> buscaPorEditora(Long id);

    List<LivroDTO> buscaPorFiltro(LivroDTO livroDTO);
}

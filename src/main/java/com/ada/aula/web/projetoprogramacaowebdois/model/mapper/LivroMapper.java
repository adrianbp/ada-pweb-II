package com.ada.aula.web.projetoprogramacaowebdois.model.mapper;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivroMapper {
	List<LivroDTO> parseListDTO(List<Livro> livros);
	List<Livro> parseListEntity(List<LivroDTO> livroDTOS);
	LivroDTO parseDTO(Livro livro);
	Livro parseEntity(LivroDTO livroDTO);
}

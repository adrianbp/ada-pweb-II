package com.ada.aula.web.projetoprogramacaowebdois.model.mapper;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivroMapper {
	List<LivroDTO> parseListDTO(List<Livro> livros);
	List<Livro> parseListEntity(List<LivroDTO> livroDTOS);

	@Mapping(source = "editoraId.id",target = "editora_id")
	@Mapping(source = "categoriaId.id",target = "categoria_id")
	LivroDTO parseDTO(Livro livro);
	@Mapping(source = "editora_id",target = "editoraId.id")
	@Mapping(source = "categoria_id",target = "categoriaId.id")
	Livro parseEntity(LivroDTO livroDTO);
}

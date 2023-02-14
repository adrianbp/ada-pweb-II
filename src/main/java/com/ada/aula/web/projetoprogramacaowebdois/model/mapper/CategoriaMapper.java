package com.ada.aula.web.projetoprogramacaowebdois.model.mapper;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	List<CategoriaDTO> parseListDTO(List<Categoria> categorias);
	List<Categoria> parseListEntity(List<CategoriaDTO> categoriaDTOS);
	CategoriaDTO parseDTO(Categoria categoria);
	Categoria parseEntity(CategoriaDTO categoriaDTO);
}

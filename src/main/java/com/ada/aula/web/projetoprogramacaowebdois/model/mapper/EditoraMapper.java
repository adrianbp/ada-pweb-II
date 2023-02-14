package com.ada.aula.web.projetoprogramacaowebdois.model.mapper;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.EditoraDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditoraMapper {
	List<EditoraDTO> parseListDTO(List<Editora> editoras);
	List<Editora> parseListEntity(List<EditoraDTO> editoraDTOS);
	EditoraDTO parseDTO(Editora editora);
	Editora parseEntity(EditoraDTO editoraDTO);
}

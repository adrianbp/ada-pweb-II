package com.ada.aula.web.projetoprogramacaowebdois.service.impl;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.EditoraDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import com.ada.aula.web.projetoprogramacaowebdois.model.mapper.EditoraMapper;
import com.ada.aula.web.projetoprogramacaowebdois.repository.EditoraRepository;
import com.ada.aula.web.projetoprogramacaowebdois.service.EditoraService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private EditoraMapper editoraMapper;

    @Override
    public List<EditoraDTO> buscarTodos() {
        return editoraMapper.parseListDTO(editoraRepository.findAll());
    }

    @Override
    public EditoraDTO buscarUm(Long id) {
        Optional<Editora> editoraOptional = editoraRepository.findById(id);
        if(editoraOptional.isPresent()) {
            Editora editora = editoraOptional.get();
            return editoraMapper.parseDTO(editora);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public EditoraDTO criar(EditoraDTO editoraDTO) {
        Editora editora = editoraMapper.parseEntity(editoraDTO);

        editora.setId(null);
        editoraRepository.save(editora);


        return editoraMapper.parseDTO(editora);
    }

    @Override
    public EditoraDTO editar(Long id, EditoraDTO editoraDTO) {

        if(editoraRepository.existsById(id)) {
            Editora editora = editoraMapper.parseEntity(editoraDTO);
            editora.setId(id);
            editora = editoraRepository.save(editora);
            return editoraMapper.parseDTO(editora);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public void excluir(Long id) {

        if(!editoraRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        editoraRepository.deleteById(id);

    }
}

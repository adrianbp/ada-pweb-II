package com.ada.aula.web.projetoprogramacaowebdois.service.impl;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.mapper.CategoriaMapper;
import com.ada.aula.web.projetoprogramacaowebdois.repository.CategoriaRespository;
import com.ada.aula.web.projetoprogramacaowebdois.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRespository categoriaRespository;

    @Autowired
    private CategoriaMapper mapper;
    @Override
    public List<CategoriaDTO> buscarTodos() {
        return mapper.parseListDTO(categoriaRespository.findAll());
    }

    @Override
    public CategoriaDTO buscarUm(Long id) {
        Optional<Categoria> categoriaOp = categoriaRespository.findById(id);
        if(categoriaOp.isPresent()) {
            Categoria categoria = categoriaOp.get();
            return mapper.parseDTO(categoria);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {

       Categoria categoria = mapper.parseEntity(categoriaDTO);

       categoria.setId(null);
       categoriaRespository.save(categoria);


        return mapper.parseDTO(categoria);
    }

    @Override
    public CategoriaDTO editar(Long id, CategoriaDTO categoriaDTO) {


        if(categoriaRespository.existsById(id)) {
            Categoria categoria = mapper.parseEntity(categoriaDTO);
            categoria.setId(id);
            categoria = categoriaRespository.save(categoria);
            return mapper.parseDTO(categoria);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public void excluir(Long id) {

        if(!categoriaRespository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        categoriaRespository.deleteById(id);

    }
}

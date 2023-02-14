package com.ada.aula.web.projetoprogramacaowebdois.service.impl;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import com.ada.aula.web.projetoprogramacaowebdois.model.mapper.EditoraMapper;
import com.ada.aula.web.projetoprogramacaowebdois.model.mapper.LivroMapper;
import com.ada.aula.web.projetoprogramacaowebdois.repository.EditoraRepository;
import com.ada.aula.web.projetoprogramacaowebdois.repository.LivroFilterRepository;
import com.ada.aula.web.projetoprogramacaowebdois.repository.LivroRepository;
import com.ada.aula.web.projetoprogramacaowebdois.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroFilterRepository livroFilterRepository;

    @Autowired
    private LivroMapper livroMapper;
    @Override
    public List<LivroDTO> buscarTodos() {
        return livroMapper.parseListDTO(livroRepository.findAll());
    }

    @Override
    public LivroDTO buscarUm(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            return livroMapper.parseDTO(livro);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public LivroDTO criar(LivroDTO livroDTO) {
        Livro livro = livroMapper.parseEntity(livroDTO);

        livro.setId(null);
        livroRepository.save(livro);


        return livroMapper.parseDTO(livro);
    }

    @Override
    public LivroDTO editar(Long id, LivroDTO livroDTO) {

        if(livroRepository.existsById(id)) {

            Livro livro = livroMapper.parseEntity(livroDTO);
            livro.setId(id);
            livro = livroRepository.save(livro);
            return livroMapper.parseDTO(livro);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public void excluir(Long id) {

        if(!livroRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        livroRepository.deleteById(id);

    }

    @Override
    public List<LivroDTO> buscaPorCategoria(Long categoriaid) {
        List<Livro> livros = livroRepository.findByCategoriaId(categoriaid);

        return livroMapper.parseListDTO(livros);

    }

    @Override
    public List<LivroDTO> buscaPorEditora(Long editoraId) {
        List<Livro> livros = livroRepository.findByEditoraId(editoraId);

        return livroMapper.parseListDTO(livros);
    }

    @Override
    public List<LivroDTO> buscaPorFiltro(LivroDTO livroDTO) {

        Livro livro = livroMapper.parseEntity(livroDTO);

        List<Livro> livros = livroFilterRepository.filtrar(livro);

        return livroMapper.parseListDTO(livros);
    }


}

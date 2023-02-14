package com.ada.aula.web.projetoprogramacaowebdois.controller;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.EditoraDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.service.EditoraService;
import com.ada.aula.web.projetoprogramacaowebdois.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController extends BaseController<LivroDTO, LivroService>{

    public LivroController(LivroService service) {
        super(service);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<LivroDTO>> buscarLivrosCategoria(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscaPorCategoria(id));
    }

    @GetMapping("/editora/{id}")
    public ResponseEntity<List<LivroDTO>> buscarLivrosEditora(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscaPorEditora(id));
    }

}

package com.ada.aula.web.projetoprogramacaowebdois.controller;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.EditoraDTO;
import com.ada.aula.web.projetoprogramacaowebdois.model.dto.LivroDTO;
import com.ada.aula.web.projetoprogramacaowebdois.service.EditoraService;
import com.ada.aula.web.projetoprogramacaowebdois.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/filter")
    public ResponseEntity<List<LivroDTO>> buscaPorFiltro(@RequestBody  LivroDTO livroDTO) {
        return ResponseEntity.ok(service.buscaPorFiltro(livroDTO));
    }

    @GetMapping("/editora/{id}")
    public ResponseEntity<List<LivroDTO>> buscarLivrosEditora(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscaPorEditora(id));
    }

}

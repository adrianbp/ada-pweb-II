package com.ada.aula.web.projetoprogramacaowebdois.controller;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.EditoraDTO;
import com.ada.aula.web.projetoprogramacaowebdois.service.EditoraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editoras")
public class EditoraController extends BaseController<EditoraDTO, EditoraService>{

    public EditoraController(EditoraService service) {
        super(service);
    }

}

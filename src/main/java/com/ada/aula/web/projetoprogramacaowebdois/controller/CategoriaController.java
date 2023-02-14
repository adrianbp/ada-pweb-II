package com.ada.aula.web.projetoprogramacaowebdois.controller;

import com.ada.aula.web.projetoprogramacaowebdois.model.dto.CategoriaDTO;
import com.ada.aula.web.projetoprogramacaowebdois.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<CategoriaDTO, CategoriaService>{

    public CategoriaController(CategoriaService service) {
        super(service);
    }

}

package com.ada.aula.web.projetoprogramacaowebdois.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditoraDTO {

    private Long id;
    @NotBlank(message="O campo nome deve estar preenchido")
    private String nome;
    private String descricao;

}

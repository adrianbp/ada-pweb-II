package com.ada.aula.web.projetoprogramacaowebdois.model.dto;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Categoria;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Editora;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroDTO {

    private Long id;
    @NotNull(message="O campo editora id deve estar preenchido")
    private Long editora_id;
    @NotNull(message="O campo categoria id deve estar preenchido")
    private Long categoria_id;
    @NotBlank(message="O campo nome deve estar preenchido")
    private String nome;
    @NotBlank(message="O campo isbn deve estar preenchido")
    private String isbn;
}

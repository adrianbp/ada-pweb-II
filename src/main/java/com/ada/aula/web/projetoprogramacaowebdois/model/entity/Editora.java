package com.ada.aula.web.projetoprogramacaowebdois.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="editora")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editora {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome", nullable=false, length = 255)
    private String nome;
    @Column(name="descricao", nullable=true)
    private String descricao;

}

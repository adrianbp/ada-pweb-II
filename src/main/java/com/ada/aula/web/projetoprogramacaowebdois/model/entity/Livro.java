package com.ada.aula.web.projetoprogramacaowebdois.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @JoinColumn(name = "editora_id", nullable = false)
    @ManyToOne()
    private Editora editoraId;

    @JoinColumn(name = "categoria_id", nullable = false)
    @ManyToOne()
    private Categoria  categoriaId;
    @Column(name="nome", nullable=false, length = 255)
    private String nome;
    @Column(name="isbn", nullable=false, length = 13)
    private String isbn;


}

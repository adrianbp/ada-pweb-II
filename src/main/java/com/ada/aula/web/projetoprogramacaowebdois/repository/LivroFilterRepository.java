package com.ada.aula.web.projetoprogramacaowebdois.repository;

import com.ada.aula.web.projetoprogramacaowebdois.model.entity.Livro;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.ada.aula.web.projetoprogramacaowebdois.model.entity.QLivro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LivroFilterRepository extends QuerydslRepositorySupport {


    public LivroFilterRepository() {
        super(Livro.class);
    }


    @PersistenceContext
    private EntityManager em;

    public List<Livro> filtrar(Livro filter){
        QLivro livro = QLivro.livro;

        List<Predicate> predicates = new ArrayList<>();

        if(filter.getNome()!=null) {
            predicates.add(livro.nome.likeIgnoreCase("%"+filter.getNome()+"%"));
        }

        if(filter.getIsbn()!=null) {
            predicates.add(livro.isbn.equalsIgnoreCase(filter.getIsbn()));
        }


        return new JPAQueryFactory(em).selectFrom(livro).where(
                predicates.toArray(new Predicate[0])
        ).fetch();
    }
}

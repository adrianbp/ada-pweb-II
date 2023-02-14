package com.ada.aula.web.projetoprogramacaowebdois.service;

import java.util.List;

public interface BaseService<T> {
	
	List<T> buscarTodos();
	T buscarUm(Long id);
	T criar(T objectDTO);
	T editar(Long id, T objectDTO);
	void excluir(Long id);
}

package br.com.financeiro.dao;

import java.util.List;

public interface GenericoDAO<T> {
	void salvar(T entidade);

	void atualizar(T entidade);

	T carregar(Integer codigo);

	void remover(T entidade);

	List<T> listar();
	
	void deleteAll();

}
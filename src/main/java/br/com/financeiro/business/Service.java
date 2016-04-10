package br.com.financeiro.business;

import java.util.List;

public interface Service<T> {
	T carregar(Integer id);

	void excluir(T entidade);

	List<T> listar();

	void salvar(T entidade);

}

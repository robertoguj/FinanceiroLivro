package br.com.financeiro.conta;

import java.util.List;

import br.com.financeiro.dao.GenericoDAO;
import br.com.financeiro.entity.Conta;
import br.com.financeiro.entity.Usuario;

public interface ContaDAO extends GenericoDAO<Conta> {

	List<Conta> listar(Usuario usuario);

	Conta buscarFavorita(Usuario usuario);

	void salvar(Conta conta);
	
	Conta carregar(Integer conta);

}

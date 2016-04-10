package br.com.financeiro.usuario;

import br.com.financeiro.dao.GenericoDAO;
import br.com.financeiro.entity.Usuario;

public interface UsuarioDAO extends GenericoDAO<Usuario> {

	Usuario buscarPorLogin(String login);

	Usuario buscarPorEmail(String email);

	Usuario carregar(Integer codigo);

	void atualizar();

}

package br.com.financeiro.usuario;

import java.util.List;

import br.com.financeiro.dao.DAOFactory;
import br.com.financeiro.entity.Usuario;

public class UsuarioRN {

	UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public Usuario buscarPorEmail(String email) {
		return this.usuarioDAO.buscarPorEmail(email);
	}

	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();

		if (codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);

		} else {
			this.usuarioDAO.atualizar(usuario);
		}

	}

	public void excluir(Usuario usuario) {
		usuarioDAO.remover(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}

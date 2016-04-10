package br.com.financeiro.dao;

import br.com.financeiro.cliente.ClienteDAO;
import br.com.financeiro.cliente.ClienteDAOHibernate;
import br.com.financeiro.conta.ContaDAO;
import br.com.financeiro.conta.ContaDAOHibernate;
import br.com.financeiro.usuario.UsuarioDAO;
import br.com.financeiro.usuario.UsuarioDAOHibernate;
import br.com.financeiro.util.HibernateUtil;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static ContaDAO criarContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDAO;
	}
	
	public static ClienteDAO criarClienteDAO() {
		ClienteDAOHibernate clienteDAO = new ClienteDAOHibernate();
		clienteDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return clienteDAO;
	}

}

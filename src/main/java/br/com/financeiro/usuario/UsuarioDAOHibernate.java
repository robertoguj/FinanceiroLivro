package br.com.financeiro.usuario;

import org.hibernate.Query;

import br.com.financeiro.dao.GenericoDAOHibernate;
import br.com.financeiro.entity.Usuario;

public class UsuarioDAOHibernate extends GenericoDAOHibernate<Usuario> implements UsuarioDAO {
	
	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = getSessao().createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		String hql = "select u from Usuario u where u.email = :email";
		Query consulta = getSessao().createQuery(hql);
		consulta.setString("email", email);
		return (Usuario) consulta.uniqueResult();
	}
	
	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) getSessao().get(Usuario.class, codigo);
	}
	
	@Override
	public void atualizar() {
		Usuario usuario = new Usuario();
		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo()); 
			usuario.setPermissao(usuarioPermissao.getPermissao());
			getSessao().evict(usuarioPermissao);
		}
		getSessao().update(usuario);
	}

}

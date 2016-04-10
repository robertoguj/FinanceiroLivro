package br.com.financeiro.conta;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.financeiro.dao.GenericoDAOHibernate;
import br.com.financeiro.entity.Conta;
import br.com.financeiro.entity.Usuario;

public class ContaDAOHibernate extends GenericoDAOHibernate<Conta> implements ContaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> listar(Usuario usuario) {
		Criteria criteria = getSessao().createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	@Override
	public Conta buscarFavorita(Usuario usuario) {
		Criteria criteria = getSessao().createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorita", true));
		return (Conta) criteria.uniqueResult();
	}
	
	@Override
	public void salvar(Conta conta) {
		this.abrirSessaoComTransacao();
		super.getSessao().saveOrUpdate(conta);
		this.fecharSessaoComTransacao();
	}
	
	@Override
	public Conta carregar(Integer conta) {
		return (Conta) super.getSessao().get(Conta.class, conta);
	}

}

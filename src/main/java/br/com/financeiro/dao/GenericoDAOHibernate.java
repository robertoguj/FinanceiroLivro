package br.com.financeiro.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financeiro.util.HibernateUtil;

public abstract class GenericoDAOHibernate<T> implements GenericoDAO<T> {

	private Session sessao;

	private Transaction transacao;

	private Class<?> classeEntidade;

	public Session abrirSessao() {
		this.sessao = HibernateUtil.getSessionFactory().openSession();
		return sessao;
	}

	public void fecharSessao() {
		this.sessao.close();
	}

	public Session abrirSessaoComTransacao() {
		this.sessao = HibernateUtil.getSessionFactory().openSession();
		this.transacao = sessao.beginTransaction();
		return sessao;
	}

	public void fecharSessaoComTransacao() {
		this.transacao.commit();
		this.sessao.close();
	}

	public void salvar(T entidade) {
		this.abrirSessaoComTransacao();
		getSessao().save(entidade);
		this.fecharSessaoComTransacao();
	}

	public void atualizar(T entidade) {
		this.abrirSessaoComTransacao();
		getSessao().update(entidade);
		this.fecharSessaoComTransacao();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T carregar(Integer codigo) {
		return (T) getSessao().get(this.classeEntidade, (Serializable) codigo);
	}

	@Override
	public void remover(T entidade) {
		this.abrirSessaoComTransacao();
		getSessao().delete(entidade);
		this.fecharSessaoComTransacao();
	}

	public void deleteAll() {
		List<T> entidadeLista = listar();
		for (T entidade : entidadeLista) {
			remover(entidade);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		List<T> lista = (List<T>) getSessao().createQuery("FROM " + getClasseEntidade().getName()).list();
		return lista;
	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public Transaction getTransacao() {
		return transacao;
	}

	public void setTransacao(Transaction transacao) {
		this.transacao = transacao;
	}

	private Class<?> getClasseEntidade() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return clazz;
	}

}

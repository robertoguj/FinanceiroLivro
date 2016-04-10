package br.com.financeiro.crud;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financeiro.entity.Contato;
import br.com.financeiro.util.HibernateUtil;

public class ContatoCrudAnnotations {
	
	private Session sessao;
	
	public ContatoCrudAnnotations(Session sessao) {
		this.sessao = sessao;
	}
	
	public void salvar(Contato contato) {
		sessao.save(contato);
	}
	
	public void atualizar(Contato contato) {
		sessao.update(contato);
	}
	
	public void excluir(Contato contato) {
		sessao.delete(contato);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> listar() {
		Query consulta = sessao.createQuery("from Contato");
		return consulta.list();
	}
	
	public Contato buscaContato(int valor) {
		Query consulta = sessao.createQuery("from Contato where codigo = :parametro");
		consulta.setInteger("parametro", valor);
		return (Contato) consulta.uniqueResult();
	}
	
	
	public static void main(String[] agrs) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		
		ContatoCrudAnnotations contatoCrud = new ContatoCrudAnnotations(sessao);
		
		// criando um primeiro contato
		Contato contato1 = new Contato();
		contato1.setNome("Beltrano Solar");
		contato1.setTelefone("98407-0432");
		contato1.setEmail("beltrano@teste.com.br");
		contato1.setDataCadastro(new Date(System.currentTimeMillis()));
		contato1.setObservacao("Novo cliente");
		contatoCrud.salvar(contato1);
		
		contato1.setObservacao("Novo cliente cadastrado");
		contatoCrud.atualizar(contato1);
		
		
		// criando um segundo contato
		Contato contato2 = new Contato();
		contato2.setNome("Fulano Lunar");
		contato2.setTelefone("98845-2056");
		contato2.setEmail("fulano@teste.com.br");
		contato2.setDataCadastro(new Date(System.currentTimeMillis()));
		contato2.setObservacao("Cliente em dia");
		contatoCrud.salvar(contato2);
		
		System.out.println("Total de registros cadastrados: " + contatoCrud.listar().size());
		contatoCrud.excluir(contato2);
		
		transacao.commit();
		System.out.println("Total de registros cadastrados: " + contatoCrud.listar().size());
		
	}

}

package br.com.financeiro.util;

import org.hibernate.Session;

public class TestaConexaoHibernate {
	
	public static void main(String[] agrs) {
		try {
			Session sessao = null;
			
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou! ");
			
			sessao.close();
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao criar conexão. Erro: " + e.getMessage());
		}
	}

}

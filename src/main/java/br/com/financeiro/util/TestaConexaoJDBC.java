package br.com.financeiro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexaoJDBC {
	
	public static void main(String[] agrs) {
		
		Connection conexao = null;
		
		try {
			// Registrando a classe JDBC e os parâmetros de conexão em tempo de execução
			String url = "jdbc:mysql://localhost/financeiro";
			String usuario = "root";
			String senha = "";
			
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
			conexao.close();
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao criar conexão. Erro: " + e.getMessage());
		}
		
	}

}

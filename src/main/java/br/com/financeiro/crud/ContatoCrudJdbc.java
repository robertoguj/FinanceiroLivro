package br.com.financeiro.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.financeiro.entity.Contato;

public class ContatoCrudJdbc {

	
	public void salvar(Contato contato) {

		Connection conexao = this.criarConexao();

		PreparedStatement insereSt = null;
		String sql = "insert into contato (nome, telefone, email, dt_cadastro, observacao) values (?, ?, ?, ?, ?)";
		
		try {
			insereSt = (PreparedStatement) conexao.prepareStatement(sql);
			insereSt.setString(1, contato.getNome());
			insereSt.setString(2, contato.getTelefone());
			insereSt.setString(3, contato.getEmail());
			insereSt.setDate(4, contato.getDataCadastro());
			insereSt.setString(5, contato.getObservacao());
			insereSt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao incluir contato. Mensagem: " + e.getMessage());
		} finally {
			try {
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operações de inserção. Mensagem: " + e.getMessage());
			}
		}
	};

	
	public void atualizar(Contato contato) {
	
	};

	
	public void excluir(Contato contato) {
	
	};

	
	public List<Contato> listar() {
		
		Connection conexao = this.criarConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		
		Statement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		String sql = "select * from contato";
		
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			
			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(resultado.getInt("codigo"));
				contato.setNome(resultado.getString("nome"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setEmail(resultado.getString("email"));
				contato.setDataCadastro(resultado.getDate("dt_cadastro"));
				contato.setObservacao(resultado.getString("observacao"));
				
				contatos.add(contato);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar código do contato. Mensagem: " + e.getMessage());
			
		} finally {
			
			try {
				consulta.close();
				resultado.close();
				conexao.close();
				
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operações de consulta. Mensagem: " + e.getMessage());
			}
			
		}
		return contatos;
	};
	

	public Contato buscaContato(int valor) {
		return null;
	};

	
	public Connection criarConexao() {
		
		Connection conexao = null;
		
		try {

			String url = "jdbc:mysql://localhost:3306/agenda";
			String usuario = "root";
			String senha = "";

			conexao = DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao criar conexão. Erro: " + e.getMessage());
		}
		
		return conexao;
	};

	
	
	public static void main(String[] agrs) {
	
		ContatoCrudJdbc contatoCrud = new ContatoCrudJdbc();
		
		// criando um primeiro contato
		Contato beltrano = new Contato();
		beltrano.setNome("Beltrano Solar");
		beltrano.setTelefone("98407-0432");
		beltrano.setEmail("beltrano@teste.com.br");
		beltrano.setDataCadastro(new Date(System.currentTimeMillis()));
		beltrano.setObservacao("Novo cliente cadastrado");
		contatoCrud.salvar(beltrano);
		
		// criando um segundo contato
		Contato fulano = new Contato();
		fulano.setNome("Fulano Lunar");
		fulano.setTelefone("98845-2056");
		fulano.setEmail("fulano@teste.com.br");
		fulano.setDataCadastro(new Date(System.currentTimeMillis()));
		fulano.setObservacao("Novo contato possível cliente");
		contatoCrud.salvar(fulano);
		
		System.out.println("Contatos cadastrados: " + contatoCrud.listar().size());
	
	};

}

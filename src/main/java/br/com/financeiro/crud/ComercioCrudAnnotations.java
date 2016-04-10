package br.com.financeiro.crud;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import br.com.financeiro.entity.Categoria;
import br.com.financeiro.entity.Cliente;
import br.com.financeiro.entity.Empregado;
import br.com.financeiro.entity.Endereco;
import br.com.financeiro.entity.Pedido;
import br.com.financeiro.entity.Pessoa;
import br.com.financeiro.entity.Produto;
import br.com.financeiro.util.HibernateUtil;

public class ComercioCrudAnnotations {
	
	private Session sessao = null;
	
	public ComercioCrudAnnotations(Session sessao) {
		this.sessao = sessao;
	}
	
	private Produto criarProdutoFilmeHobbit() {
		Categoria categoriaFilmes = new Categoria("Filmes", "Categoria de filmes");
		sessao.save(categoriaFilmes);
		
		Produto produto = new Produto();
		produto.setDescricao("O Hobbit");
		produto.setPreco(29.99f);
		produto.setCategoria(categoriaFilmes);
		sessao.save(produto);
		
		return produto;
	}
	
	private Produto criarProdutoLivroPeregrino() {
		Categoria categoriaLivro = new Categoria("Livro", "Categoria de Livros");
		sessao.save(categoriaLivro);
		
		Produto produto = new Produto();
		produto.setDescricao("O Peregrino");
		produto.setPreco(15.75f);
		produto.setCategoria(categoriaLivro);
		sessao.save(produto);
		
		return produto;
	}
	
	private Produto criarProdutoAlimentoMistoQuente() {
		Categoria categoriaAlimentos = new Categoria("Alimento", "Categoria de alimentos");
		sessao.save(categoriaAlimentos);
		
		Produto produto = new Produto();
		produto.setDescricao("Misto Quente");
		produto.setPreco(1.99f);
		produto.setCategoria(categoriaAlimentos);
		sessao.save(produto);
		
		return produto;
	}
	
	private Cliente criarClienteBeltrano() {
		Cliente cliente = new Cliente();
		cliente.setNome("Beltrano");
		
		Endereco endereco = new Endereco();
		endereco.setEndereco("Rua Luciano Alves");
		endereco.setNumero(3331);
		endereco.setComplemento("APTO. 08");
		endereco.setCep("60870-640");
		endereco.setMunicipio("Fortaleza");
		endereco.setUf("CE");
		
		cliente.setEndereco(endereco);
		sessao.save(cliente);
		
		return cliente;
	}
	
	private Cliente criarClienteFulano() {
		Cliente cliente = new Cliente();
		cliente.setNome("Fulano");
		
		Endereco endereco = new Endereco();
		endereco.setEndereco("Av. Val Paraíso");
		endereco.setNumero(1938);
		endereco.setComplemento(null);
		endereco.setCep("60991-130");
		endereco.setMunicipio("Fortaleza");
		endereco.setUf("CE");
		
		cliente.setEndereco(endereco);
		sessao.save(cliente);
		
		return cliente;
	}
	
	private Empregado criarEmpregadoMelo() {
		Empregado chefe = new Empregado();
		chefe.setNome("Roberto");
		sessao.save(chefe);
		
		Empregado empregado = new Empregado();
		empregado.setNome("Melo");
		empregado.setChefe(chefe);
		sessao.save(empregado);
		
		return empregado;
	}
	
	private Empregado criarEmpregadoLucas() {
		Empregado empregado = new Empregado();
		empregado.setNome("Lucas");
		sessao.save(empregado);
		
		return empregado;
	}
	
	
	public void criarPedidos() {
		
		Produto filmeHobbit = criarProdutoFilmeHobbit();
		Produto livroPeregrino = criarProdutoLivroPeregrino();
		Produto alimentoMistoQuente = criarProdutoAlimentoMistoQuente();
		Empregado empregadoLucas = criarEmpregadoLucas();
		Empregado empregadoMelo = criarEmpregadoMelo();
		
		/**
		 * Pedido do Sr. Fulano
		 */
		
		Cliente clienteFulano = criarClienteFulano();
		
		Pedido pedido = new Pedido();
		pedido.setCliente(clienteFulano);
		pedido.setEmpregado(empregadoLucas);
		pedido.setDescricao("Pedido do Sr. Fulano");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		
		Set<Produto> produtos = new HashSet<Produto>();
		pedido.setProduto(produtos);
		
		produtos.add(filmeHobbit);
		produtos.add(livroPeregrino);
		sessao.save(pedido);
		
		/**
		 * Pedido do Sr. Beltrano
		 */
		
		Cliente clienteBeltrano = criarClienteBeltrano();
		
		pedido = new Pedido();
		pedido.setCliente(clienteBeltrano);
		pedido.setEmpregado(empregadoMelo);
		pedido.setDescricao("Pedido do Sr. Beltrano");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		
		produtos = new HashSet<Produto>();
		pedido.setProduto(produtos);
		
		produtos.add(filmeHobbit);
		produtos.add(alimentoMistoQuente);
		sessao.save(pedido);
		
	}
	
	
	public static void main(String[] agrs) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		ComercioCrudAnnotations comercio = new ComercioCrudAnnotations(sessao);
		
		comercio.criarPedidos();
		System.out.println("Cadastrou!");
	}

}

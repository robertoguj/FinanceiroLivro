package br.com.financeiro.crud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.financeiro.cliente.ClienteRN;
import br.com.financeiro.entity.Cliente;
import br.com.financeiro.entity.Endereco;
import br.com.financeiro.entity.enuns.TipoPessoa;

public class ClienteCrud {
	
	private Date date;
	private ClienteRN clienteRN;
	
	public ClienteCrud() {
		this.clienteRN = new ClienteRN();
	}
	
	public void cadastrarCliente() {
		
		ClienteRN clienteRN = new ClienteRN();

		
		// cadastro cliente1
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setTipoPessoa(TipoPessoa.JURÍDICA);
		cliente1.setNome("Construtora Marquise");
		cliente1.setCnpj("745.356.233/0001-02");
		cliente1.setInscricaoEstadual("456.654-67");
		cliente1.setPessoaResponsavel("Antônio");
		
		Date data = new Date(System.currentTimeMillis());
		cliente1.setDataCadastro(data);
		
		Endereco endereco = new Endereco();
		endereco.setCep("60870-640");
		endereco.setEndereco("Rua Luciano Alves");
		endereco.setNumero(3331);
		endereco.setComplemento("Apto. 08");
		endereco.setBairro("Jangurussu");
		endereco.setMunicipio("Fortaleza");
		endereco.setUf("CE");
		cliente1.setEndereco(endereco);
		
		cliente1.setEmail("jrobertopr@hotmail.com");
		cliente1.setTelefone("(85)3267-2452");
		cliente1.setCelular("(85)98407-0432");
	
		
		
		
		
		// cadastro cliente2
		
		Cliente cliente2 = new Cliente();

		cliente2.setTipoPessoa(TipoPessoa.FÍSICA);
		cliente2.setNome("Carlos Machado do Nascimento");
		cliente2.setCpf("741.235.133-87");
		cliente2.setRg("940.090.191-28");
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.date = sdf.parse("24/06/1977");
			cliente2.setNascimento(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		this.date = new Date(System.currentTimeMillis());
		cliente2.setDataCadastro(date);
		
		Endereco endereco2 = new Endereco();
		endereco2.setCep("60870-640");
		endereco2.setEndereco("Rua Luciano Alves");
		endereco2.setNumero(3331);
		endereco2.setComplemento("Apto. 08");
		endereco2.setBairro("Jangurussu");
		endereco2.setMunicipio("Fortaleza");
		endereco2.setUf("CE");
		cliente2.setEndereco(endereco2);
		
		cliente2.setEmail("jrobertopr@hotmail.com");
		cliente2.setTelefone("(85)3267-2452");
		cliente2.setCelular("(85)98407-0432");
		
		
		clienteRN.salvar(cliente1);
		clienteRN.salvar(cliente2);
		
		System.out.println("Cadastrado com sucesso! ");
		
	}
	

	public static void main(String[] args) {
		ClienteCrud cliente = new ClienteCrud();
		cliente.cadastrarCliente();

	}

}

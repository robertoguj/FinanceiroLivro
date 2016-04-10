package br.com.financeiro.cliente;

import br.com.financeiro.controller.AbstractController;
import br.com.financeiro.entity.Cliente;

public class ClienteMB extends AbstractController {
	
	private Cliente cliente = new Cliente();
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}

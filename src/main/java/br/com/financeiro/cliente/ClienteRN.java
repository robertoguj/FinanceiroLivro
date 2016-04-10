package br.com.financeiro.cliente;

import br.com.financeiro.dao.DAOFactory;
import br.com.financeiro.entity.Cliente;

public class ClienteRN {
	
	ClienteDAO clienteDAO;
	
	public ClienteRN() {
		this.clienteDAO = DAOFactory.criarClienteDAO();
	}
	
	public void salvar(Cliente cliente) {
		this.clienteDAO.salvar(cliente);
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
}

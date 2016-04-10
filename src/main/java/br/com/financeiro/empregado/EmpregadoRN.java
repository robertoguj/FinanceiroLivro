package br.com.financeiro.empregado;

import java.util.List;

import br.com.financeiro.entity.Empregado;

public class EmpregadoRN {
	
	private static EmpregadoDAOHibernate empregadoDAO;

	public EmpregadoRN() {
		empregadoDAO = new EmpregadoDAOHibernate();
	}

	public void salvar(Empregado empregado) {
		empregadoDAO.abrirSessaoComTransacao();
		empregadoDAO.salvar(empregado);
		empregadoDAO.fecharSessaoComTransacao();
	}

	public void atualizar(Empregado empregado) {
		empregadoDAO.abrirSessaoComTransacao();
		empregadoDAO.atualizar(empregado);
		empregadoDAO.fecharSessaoComTransacao();
	}

	public Empregado buscarPorId(Integer id) {
		empregadoDAO.abrirSessao();
		Empregado empregado = empregadoDAO.carregar(id);
		empregadoDAO.fecharSessao();
		return empregado;
	}

	public void excluir(Integer id) {
		empregadoDAO.abrirSessaoComTransacao();
		Empregado empregado = empregadoDAO.carregar(id);
		empregadoDAO.remover(empregado);
		empregadoDAO.fecharSessaoComTransacao();
	}

	public List<Empregado> listar() {
		empregadoDAO.abrirSessao();
		List<Empregado> empregados = empregadoDAO.listar();
		empregadoDAO.fecharSessao();
		return empregados;
	}
	
	public void deleteAll() {
		empregadoDAO.abrirSessaoComTransacao();
		empregadoDAO.deleteAll();
		empregadoDAO.fecharSessaoComTransacao();
	}

	public EmpregadoDAOHibernate empregadoDao() {
		return empregadoDAO;
	}

}

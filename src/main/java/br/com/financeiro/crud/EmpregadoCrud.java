package br.com.financeiro.crud;

import java.util.List;

import br.com.financeiro.empregado.EmpregadoRN;
import br.com.financeiro.entity.Empregado;

public class EmpregadoCrud {
	
	private EmpregadoRN empregadoRN;

	public EmpregadoCrud() {
		empregadoRN = new EmpregadoRN();
	}
	
	/**
	 * Listando Empregados
	 * @return	Empregados
	 */	
	public List<Empregado> listarEmpregados() {

		List<Empregado> empregados = empregadoRN.listar();
		
		for (Empregado e : empregados) {
			System.out.println("-" + e.toString());
		}
		
		System.out.println("Total de empregados: " + empregadoRN.listar().size());
		
		return empregados;
	}
	
	public void excluirTodosEmpregados() {
		empregadoRN.deleteAll();
	}

	public void cadastrarEmpregados() {

		EmpregadoRN empregadoService = new EmpregadoRN();
		
		Empregado empregado1 = new Empregado("José Antônio", "307-06", "Arquiteto de Software");
		Empregado empregado2 = new Empregado("Filipe Alencar", "405-45", "Engenheiro de Software");
		Empregado empregado3 = new Empregado("Marcos Monteiro", "321-76", "Analista de Suporte");

		empregadoService.salvar(empregado1);
		empregadoService.salvar(empregado2);
		empregadoService.salvar(empregado3);
		
		System.out.println("Empregados cadastrados com sucesso! ");

	}
	
	public void atualizarEmpregado() {
		
		/*
		// Atualizando empregado
		empregado1.setFuncao("Arquiteto de sistemas");
		empregadoService.atualizar(empregado2);
				

		// Localizando empregado
		Integer id1 = empregado1.getId();
		Empregado e = empregadoService.buscarPorId(id1);
		System.out.println("Empregado com id " + id1 + " chama-se " + e.toString());

				
		// Removendo empregado
		Integer id3 = empregado3.getId();
		empregadoService.excluir(id3);
		System.out.println("Removendo empregado com id3 " + id3 + ".");
		System.out.println("Agora todos os empregados são " + empregadoService.buscarTodos().size() + ".");
		*/
	}
	
	
	
	public static void main(String[] agrs) {

		EmpregadoCrud empregado = new EmpregadoCrud();
		empregado.cadastrarEmpregados();
		
		System.exit(0);

	}

}

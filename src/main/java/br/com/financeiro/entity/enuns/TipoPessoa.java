package br.com.financeiro.entity.enuns;

import java.util.EnumSet;

public enum TipoPessoa {
	
	FÍSICA("Pessoa Física"),
	JURÍDICA("Pessoa Jurídica");

	private final String descricao;
	
	private TipoPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EnumSet<TipoPessoa> getListaTipoPessoa() {
        return EnumSet.of(FÍSICA, JURÍDICA);
    }
	
}

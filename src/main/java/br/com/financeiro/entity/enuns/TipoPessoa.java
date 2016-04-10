package br.com.financeiro.entity.enuns;

import java.util.EnumSet;

public enum TipoPessoa {
	
	F�SICA("Pessoa F�sica"),
	JUR�DICA("Pessoa Jur�dica");

	private final String descricao;
	
	private TipoPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EnumSet<TipoPessoa> getListaTipoPessoa() {
        return EnumSet.of(F�SICA, JUR�DICA);
    }
	
}

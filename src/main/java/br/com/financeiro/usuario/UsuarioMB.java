package br.com.financeiro.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.financeiro.conta.ContaRN;
import br.com.financeiro.controller.AbstractController;
import br.com.financeiro.entity.Conta;
import br.com.financeiro.entity.Usuario;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB extends AbstractController implements Serializable {
	private static final long serialVersionUID = 474501220107193383L;

	private Usuario usuario = new Usuario();
	private List<SelectItem> idiomas;
	private String confirmarSenha;
	private String destinoSalvar;
	private List<Usuario> lista;
	private Conta conta = new Conta();

	public List<Usuario> getLista() {

		UsuarioRN usuarioRN = new UsuarioRN();

		if (this.lista == null) {
			this.lista = usuarioRN.listar();
		}
		return lista;
	}

	public String consultar() {

		UsuarioRN usuarioRN = new UsuarioRN();
		this.lista = usuarioRN.listar();

		total = lista.size();
		if (total == 0) {
			addInfoMessage("Nenhum registro encontrado! ");
		}
		return "/admin/principal.jsf?faces-redirect=true";
	}

	public void resetarCampos() {
		this.confirmarSenha = null;
		this.usuario = null;
		this.usuario = new Usuario();
		this.lista = new ArrayList<Usuario>();
	}

	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		resetarCampos();
		this.usuario.setAtivo(true);
		return "usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario.jsf?faces-redirect=true";
	}

	public String salvar() {

		// String login, email;
		// login = this.usuario.getLogin();
		// email = this.usuario.getEmail();

		if (!this.usuario.getSenha().equalsIgnoreCase(this.confirmarSenha)) {
			addErrorMessage("Senha confirmada incorretamente.");
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();

		/*
		 * if(usuarioRN.buscarPorLogin(login) != null) { addErrorMessage(
		 * "Login já existe!"); return null; }
		 * if(usuarioRN.buscarPorEmail(email) != null) { addErrorMessage(
		 * "Email já existe!"); return null; }
		 */
		usuarioRN.salvar(this.usuario);
		
		if (this.conta.getDescricao() != null) {
			this.conta.setUsuario(this.usuario);
			this.conta.setFavorita(true);
			ContaRN contaRN = new ContaRN();
			contaRN.salvar(this.conta);
		}

		return this.destinoSalvar;
	}

	
	private String atribuirPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();

		if (permissao.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return null;
	}

	public List<SelectItem> getIdiomas() {
		if (this.idiomas == null) {
			this.idiomas = new ArrayList<SelectItem>();
			this.idiomas.add(new SelectItem("pt_BR", "Português"));
			this.idiomas.add(new SelectItem("en_US", "English"));
			this.idiomas.add(new SelectItem("es_ES", "Espanol"));
		}
		return idiomas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	

}

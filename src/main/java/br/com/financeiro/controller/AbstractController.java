package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public abstract class AbstractController {
	
	protected int total = 0;
	
	protected List<SelectItem> estados;

	public List<SelectItem> getEstados() {
		if (this.estados == null) {
			this.estados = new ArrayList<SelectItem>();
			this.estados.add(new SelectItem("AC", "Acre"));
			this.estados.add(new SelectItem("AL", "Alagoas"));
			this.estados.add(new SelectItem("AP", "Amap�"));
			this.estados.add(new SelectItem("AM", "Amazonas"));
			this.estados.add(new SelectItem("BA", "Bahia"));
			this.estados.add(new SelectItem("CE", "Cear�"));
			this.estados.add(new SelectItem("DF", "Distrito Federal"));
			this.estados.add(new SelectItem("ES", "Esp�rito Santo"));
			this.estados.add(new SelectItem("GO", "Goi�s"));
			this.estados.add(new SelectItem("MA", "Maranh�o"));
			this.estados.add(new SelectItem("MT", "Mato Grosso"));
			this.estados.add(new SelectItem("MS", "Mato Grosso do Sul"));
			this.estados.add(new SelectItem("MG", "Minas Gerais"));
			this.estados.add(new SelectItem("PA", "Par�"));
			this.estados.add(new SelectItem("PB", "Para�ba"));
			this.estados.add(new SelectItem("PE", "Pernambuco"));
			this.estados.add(new SelectItem("PI", "Piau�"));
			this.estados.add(new SelectItem("RJ", "Rio de Janeiro"));
			this.estados.add(new SelectItem("RN", "Rio Grande do Norte"));
			this.estados.add(new SelectItem("RO", "Rond�nia"));
			this.estados.add(new SelectItem("RR", "Roraima"));
			this.estados.add(new SelectItem("SP", "S�o Paulo"));
			this.estados.add(new SelectItem("SE", "Sergipe"));
			this.estados.add(new SelectItem("TO", "Tocantins"));
		}
		return estados;
	}

	public static void addInfoMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}

	public static void addWarnMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}

	public static void addErrorMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}

	public String getMessage(String key) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ResourceBundle rb = ResourceBundle.getBundle("messages", fc.getViewRoot().getLocale());
			String mensagem = rb.getString(key);
			return mensagem;
		} catch (Exception e) {
			return "";
		}
	}

}

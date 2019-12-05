package Circularizacao;

import java.io.Serializable;

public class Cooperativa implements Serializable, Autenticavel{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id;
		private String cnpj; 
		private String razaoSocial;
		private String senha;
		
	public Cooperativa(int id,String cnpj, String razaoSocial) {
		this.setId(id);
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
		this.setSenha(cnpj + cnpj);
	}
	public Cooperativa() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean verificaSenha(String senha, String login) {
		if(senha.equals(this.getSenha()) && login.equals(this.getCnpj())) {
			return true;
		}
		else {
			return false;
		}
	}
}

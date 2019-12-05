package Circularizacao;

import java.io.Serializable;

public class Advogado extends Circularizados implements Serializable,Autenticavel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String registroOab;
	private String contratoAnalisado;
	public int contLaudos = 0;
	private String senha;

	public Advogado(int id,String registroOab, String cpfCnpj, String nome) {
		
		super(cpfCnpj, nome);
		this.setId(id);
		this.setRegistroOab(registroOab);
		this.setSenha(nome + nome);
		
	}
	public Advogado() {
		super();
	}

	public String getRegistroOab() {
		return registroOab;
	}

	public void setRegistroOab(String registroOab) {
		this.registroOab = registroOab;
	}

	public String getContratoAnalisado() {
		return contratoAnalisado;
	}

	public void setContratoAnalisado(String contratoAnalisado) {
		this.contratoAnalisado = contratoAnalisado;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Advogado) {
			return (((Advogado) obj).getRegistroOab() == this.getRegistroOab());
		}
		return false;
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
		if(senha.equals(this.getSenha()) && login.equals(this.getNome())) {
			return true;
		}
		else {
			return false;
		}
	}


}

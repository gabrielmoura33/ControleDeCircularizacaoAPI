package Circularizacao;

import java.io.Serializable;

public abstract class Circularizados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpfCnpj;
	private String nome;
	
	
	public Circularizados(String cpfCnpj, String nome) {
		
		this.setcpfCnpj(cpfCnpj);
		this.setNome(nome);
		
	}


	public Circularizados() {
		super();
	}


	public String getcpfCnpj() {
		return cpfCnpj;
	}


	public void setcpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}

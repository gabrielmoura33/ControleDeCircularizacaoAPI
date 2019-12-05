package Circularizacao;

import java.io.Serializable;

public abstract class Resposta implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int protocolo; 
	public int idProcesso; 
	
	
	public Resposta(int idProcesso) {

		this.idProcesso = idProcesso;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public abstract void AtualizaProcesso(ProcessoAuditoria processo);
	
}

package Circularizacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ProcessoAuditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dataDisparo;
	private LocalDateTime dataRecebimento;
	private String status;
	public int cooperativas_id;
	public int auditoria_id;
	private int idProcesso; 
	
	
	public ProcessoAuditoria(int idProcesso,int auditoria_id, int cooperativas_id,  LocalDate dateDisparo) {
		this.setIdProcesso(idProcesso);
		this.auditoria_id = auditoria_id;
		this.cooperativas_id = cooperativas_id;
		this.setDataDisparo(dateDisparo);
		this.setStatus("PENDENTE");
	}

	public ProcessoAuditoria () {
		super();
	}
	public String getDataDisparo() {
		return dataDisparo;
	}

	public void setDataDisparo(LocalDate dateDisparo) {
		this.dataDisparo = dateDisparo.toString();
	}



	public LocalDateTime getDataRecebimento() {
		return dataRecebimento;
	}



	public void setDataRecebimento(LocalDateTime localDateTime) {
		this.dataRecebimento = localDateTime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	public int getIdProcesso() {
		return idProcesso;
	}


	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}
}

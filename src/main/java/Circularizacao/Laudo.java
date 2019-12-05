package Circularizacao;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Laudo extends Resposta implements Serializable{

	
	/**
	 * 
	 */
	private static int maxId = 0;
	private static final long serialVersionUID = 1L;
	private int id;
	private String contrato;
	private String dataEnvio;
	private String descricaoProcesso;
	private String parecer;
	
	public Laudo(String contrato, LocalDateTime dataEnvio,String descricaoProcesso,String parecer,int idProcesso){
		super(idProcesso);
		this.setContrato(contrato);
		this.setDataEnvio(dataEnvio);
		this.setDescricaoProcesso(descricaoProcesso);
		this.setParecer(parecer);
		this.setId(++maxId);
	}

	public String getContrato() {
		return contrato;
	}


	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public String getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio.toString();
	}

	public String getDescricaoProcesso() {
		return descricaoProcesso;
	}

	public void setDescricaoProcesso(String descricaoProcesso) {
		this.descricaoProcesso = descricaoProcesso;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	@Override
	public void AtualizaProcesso(ProcessoAuditoria processo) {
		if(processo.getIdProcesso() == this.idProcesso) {
			processo.setStatus("RECEBIDO");
			processo.setDataRecebimento(LocalDateTime.now());
		}
		else {
			System.out.println("Identificadores N�o Encontrado");
		}	
		
	}

	public static int getMaxId() {
		return maxId;
	}

	public static void setMaxId(int maxid) {
		Laudo.maxId = maxid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

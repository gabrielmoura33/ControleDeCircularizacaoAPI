package Circularizacao;

import dao.AdvogadoDAO;
import dao.AuditoriaDAO;
import dao.CooperativaDAO;
import dao.processoAuditoriaDAO;

public class CircularizacaoInit {
	public static final AuditoriaDAO auditoriaDao = initiateAuditoria();
	public static AuditoriaDAO initiateAuditoria() {
		AuditoriaDAO audi = null;
		try {
			audi = new AuditoriaDAO("auditorias.bin");
		} catch (Exception e) {
			System.out.println("Erro Ao Conectar com Arquivo de Auditorias");
		}
		return audi;
	}	
	
	public static final CooperativaDAO cooperativaDao = initiateCooperativa();
	public static CooperativaDAO initiateCooperativa() {
		CooperativaDAO coop = null;
		try {
			coop = new CooperativaDAO("cooperativas.bin");
		} catch (Exception e) {
			System.out.println ("Erro Ao Conectar com Arquivo de Cooperativas");
		}
		return coop;
	}
	public static final AdvogadoDAO advogadoDao = initiateAdvogado();
	public static AdvogadoDAO initiateAdvogado() {
		AdvogadoDAO advogado = null;
		try {
			advogado = new AdvogadoDAO("advogados.bin");
		} catch (Exception e) {
			System.out.println("Erro Ao Iniciar o Arquivo de advogados");
		}
		return advogado;		
	}
	
	public static final processoAuditoriaDAO processoDao = initiateProcesso();
	public static processoAuditoriaDAO initiateProcesso() {
		processoAuditoriaDAO processo = null;
		try {
			processo = new processoAuditoriaDAO("processoAuditoria.bin");
		} catch (Exception e) {
			System.out.println("Erro Ao Iniciar o Arquivo de Processo");
		}
		return processo;		
	}
	
}

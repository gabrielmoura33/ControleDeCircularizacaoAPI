package Aplication;

import java.io.IOException;
import java.time.LocalDate;
import Circularizacao.Advogado;
import Circularizacao.Auditoria;
import Circularizacao.CircularizacaoInit;
import Circularizacao.Cooperativa;
import Circularizacao.ProcessoAuditoria;

public class Aplicacao {

	

	public static void main(String[] args) throws IOException {
		
		Auditoria aud = new Auditoria(1,"Admin","AUDITORIA DE TESTE");		
		Cooperativa coop = new Cooperativa(1,"ADMIN","COOPERATIVA ADMIN");
		Advogado adv = new Advogado(1,"REGISTRO","11606499602","GABRIEL");
		
		
		ProcessoAuditoria procss = new ProcessoAuditoria(1,aud.getId(),coop.getId(),LocalDate.now());
		
		CircularizacaoInit.advogadoDao.add(adv);
		CircularizacaoInit.auditoriaDao.add(aud);
		CircularizacaoInit.cooperativaDao.add(coop);
		CircularizacaoInit.processoDao.add(procss);
		
		System.out.println(CircularizacaoInit.processoDao.getAll());
	}

}

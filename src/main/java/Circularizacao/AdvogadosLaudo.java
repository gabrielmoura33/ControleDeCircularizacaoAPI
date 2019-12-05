package Circularizacao;

public class AdvogadosLaudo {

	public Advogado advogado;
	public Laudo laudo;
	public int idLaudo = 0;
	

	
	public AdvogadosLaudo(Advogado advogado, Laudo laudo) {	
		this.idLaudo ++;
		this.advogado = advogado;
		this.laudo = laudo; 	
		
	}

}

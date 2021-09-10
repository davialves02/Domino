package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

public class EstrategiaDeJogoComposta implements EstrategiaDeJogo{
	private int indice = 0;
	private List<EstrategiaDeJogo> estrategias;
	
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = estrategias;
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if(indice == estrategias.size()) {
			indice = 1;
		}else {
			indice++;
		}
		
		return estrategias.get(indice-1).decideJogada(mao, mesa);
		
	}
}

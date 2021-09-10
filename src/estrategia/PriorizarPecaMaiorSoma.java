package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
/**
 * Prioriza jogar sempre a peça que possui a maior soma do lado direito e esquerdo. Caso não encaixe em nenhum dos lados da mesa, joga a primeira peça
 * da mão que encaixar.
 */
public class PriorizarPecaMaiorSoma implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		Peca pecaMaiorSoma = mao.get(0);
		for(Peca peca: mao) {
			if(peca.getSoma() > pecaMaiorSoma.getSoma()) {
				pecaMaiorSoma = peca;
			}
		}
		if (mesa.getNumPecas() == 0) {
			return new Jogada(pecaMaiorSoma, TipoJogada.NA_DIREITA);
		}
		
		if (pecaMaiorSoma.encaixa(mesa.getNumNaDireita()) && pecaMaiorSoma.encaixa(mesa.getNumNaEsquerda())) {
			return new Jogada(pecaMaiorSoma, TipoJogada.DIREITA_ESQUERDA);
		}
		if (pecaMaiorSoma.encaixa(mesa.getNumNaDireita())) {
			return new Jogada(pecaMaiorSoma, TipoJogada.NA_DIREITA);
		}
		if (pecaMaiorSoma.encaixa(mesa.getNumNaEsquerda())) {
			return new Jogada(pecaMaiorSoma, TipoJogada.NA_ESQUERDA);
		}
		
		for(Peca peca : mao) {
			if (peca.encaixa(mesa.getNumNaDireita()) && peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.DIREITA_ESQUERDA);
			}
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}
		
		return new Jogada();
	}
	
	@Override
	public String toString() {
		return "Priorizar Peca de Maior Soma";
	}
}

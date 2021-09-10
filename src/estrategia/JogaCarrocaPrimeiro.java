package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
/**
 * Prioriza jogar as peças que são carroças. Encaixa ela em qual lado da mesa for possível encaixar.
 */
public class JogaCarrocaPrimeiro implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		// joga primeiro as carroças.
		for(Peca peca : mao) {
			if(peca.ehCarroca()) {
				if (mesa.getNumPecas() == 0) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
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
		}
		
		for(Peca peca : mao) {
			if (mesa.getNumPecas() == 0) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
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
		return "Joga Carroça Primeiro";
	}
}

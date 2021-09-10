package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarrocaPrimeiro;
import ufcg.ccc.domino.estrategia.PriorizarPecaMaiorSoma;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
		/**
		 * Quantas vitórias de cada tipo o jogador 1 conquistou.
		 */
		int vitoriasJ1Normais = 0, vitoriasJ1Carroca = 0, vitoriasJ1LaELo = 0, vitoriasJ1Cruzadas = 0;
		/**
		 * Quantas vitórias de cada tipo o jogador 2 conquistou.
		 */
		int vitoriasJ2Normais = 0, vitoriasJ2Carroca = 0, vitoriasJ2LaELo = 0, vitoriasJ2Cruzadas = 0;
		/**
		 * Pontuação de vitórias de cada tipo que o jogador 1 conquistou.
		 */
		int pontuacaoJ1Normais = 0, pontuacaoJ1Carroca = 0, pontuacaoJ1LaELo = 0, pontuacaoJ1Cruzadas = 0;
		/**
		 * Pontuação de vitórias de cada tipo que o jogador 2 conquistou.
		 */
		int pontuacaoJ2Normais = 0, pontuacaoJ2Carroca = 0, pontuacaoJ2LaELo = 0, pontuacaoJ2Cruzadas = 0;

		EstrategiaDeJogo estrategia1 = new PriorizarPecaMaiorSoma(), estrategia2 = new JogaCarrocaPrimeiro(); 
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estratégia começa jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			// Contagem de empates, vitórias de cada jogador e pontuação dos tipos de vitórias.
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				if(historico.getTipoPontuacao() == "normal") {
					vitoriasJ1Normais++;
					pontuacaoJ1Normais++;
				}
				if(historico.getTipoPontuacao() == "carroça") {
					vitoriasJ1Carroca++;
					pontuacaoJ1Carroca += 2;
				}
				if(historico.getTipoPontuacao() == "laELo") {
					vitoriasJ1LaELo++;
					pontuacaoJ1LaELo += 3;
				}
				if(historico.getTipoPontuacao() == "cruzada") {
					vitoriasJ1Cruzadas++;
					pontuacaoJ1Cruzadas += 6;
				}
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				if(historico.getTipoPontuacao() == "normal") {
					vitoriasJ2Normais++;
					pontuacaoJ2Normais++;
				}
				if(historico.getTipoPontuacao() == "carroça") {
					vitoriasJ2Carroca++;
					pontuacaoJ2Carroca += 2;
				}
				if(historico.getTipoPontuacao() == "laELo") {
					vitoriasJ2LaELo++;
					pontuacaoJ2LaELo += 3;
				}
				if(historico.getTipoPontuacao() == "cruzada") {
					vitoriasJ2Cruzadas++;
					pontuacaoJ2Cruzadas += 6;
				}
			}
		}
		/**
		 * Pontuação total de vitórias que o jogador 1 conquistou.
		 */
		int pontuacaoTotalJ1 = pontuacaoJ1Normais + pontuacaoJ1Carroca + pontuacaoJ1LaELo + pontuacaoJ1Cruzadas;
		/**
		 * Pontuação total de vitórias que o jogador 2 conquistou.
		 */
		int pontuacaoTotalJ2 = pontuacaoJ2Normais + pontuacaoJ2Carroca + pontuacaoJ2LaELo + pontuacaoJ2Cruzadas;
		
		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vitórias E1:\t" + vitoriasJ1 + " vitórias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%) " + pontuacaoTotalJ1 + " pontos"
				+ "\n- E1:  Vitórias Normais: " + vitoriasJ1Normais + "(" + pontuacaoJ1Normais + "p)  Vitórias de Carroça: " + vitoriasJ1Carroca + "(" + pontuacaoJ1Carroca + "p)  Vitórias de Lá e Ló: " + vitoriasJ1LaELo + "(" + pontuacaoJ1LaELo + "p)  Vitórias de Cruzada: " + vitoriasJ1Cruzadas + "(" + pontuacaoJ1Cruzadas + "p)" 
				+ "\n- Vitórias E2:\t" + vitoriasJ2 + " vitórias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%) " + pontuacaoTotalJ2 + " pontos"
				+ "\n- E2:  Vitórias Normais: " + vitoriasJ2Normais + "(" + pontuacaoJ2Normais + "p)  Vitórias de Carroça: " + vitoriasJ2Carroca + "(" + pontuacaoJ2Carroca + "p)  Vitórias de Lá e Ló: " + vitoriasJ2LaELo + "(" + pontuacaoJ2LaELo + "p)  Vitórias de Cruzada: " + vitoriasJ2Cruzadas + "(" + pontuacaoJ2Cruzadas + "p)" 
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)");
	}

}

package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class EstrategiaDeJogoCompostaTest {
	
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void testPassa() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new PriorizarPecaMaiorSoma());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testUsaPrimeiraEstrategiaDireita() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new PriorizarPecaMaiorSoma());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 0), new Peca(1, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(0, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testUsaPrimeiraEstrategiaEsquerda() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new PriorizarPecaMaiorSoma());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 0), new Peca(1, 6)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(0, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testUsaPrimeiraEstrategiaDireitaEsquerda() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new PriorizarPecaMaiorSoma());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 1), new Peca(2, 6)), mesa);
		
		assertEquals(TipoJogada.DIREITA_ESQUERDA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	// é usada primeiro a estratégia JogaPrimeiraPossível e depois testa a PriorizaPecaMaiorSoma
	@Test
	void testUsaSegundaEstrategiaDireita() {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new PriorizarPecaMaiorSoma());
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 0), new Peca(1, 4)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(0, j1.getPeca().getNumDireito());
		
		Jogada j2 = estrategia.decideJogada(List.of(new Peca(1, 4), new Peca(2, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());
		assertEquals(2, j2.getPeca().getNumEsquerdo());
		assertEquals(6, j2.getPeca().getNumDireito());
	}

	// é usada primeiro a estratégia JogaPrimeiraPossível e depois testa a PriorizaPecaMaiorSoma
		@Test
		void testUsaSegundaEstrategiaEsquerda() {
			List<EstrategiaDeJogo> estrategias = new ArrayList<>();
			estrategias.add(new JogaPrimeiraPossivel());
			estrategias.add(new PriorizarPecaMaiorSoma());
			EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

			Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 0), new Peca(1, 4)), mesa);

			assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
			assertEquals(2, j1.getPeca().getNumEsquerdo());
			assertEquals(0, j1.getPeca().getNumDireito());
			
			Jogada j2 = estrategia.decideJogada(List.of(new Peca(2, 4), new Peca(1, 6)), mesa);

			assertEquals(TipoJogada.NA_ESQUERDA, j2.getTipo());
			assertEquals(1, j2.getPeca().getNumEsquerdo());
			assertEquals(6, j2.getPeca().getNumDireito());
	}
	
		// é usada primeiro a estratégia JogaPrimeiraPossível e depois testa a PriorizaPecaMaiorSoma
		@Test
		void testUsaSegundaEstrategiaDireitaEsquerda() {
			List<EstrategiaDeJogo> estrategias = new ArrayList<>();
			estrategias.add(new JogaPrimeiraPossivel());
			estrategias.add(new PriorizarPecaMaiorSoma());
			EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

			Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 0), new Peca(1, 4)), mesa);

			assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
			assertEquals(2, j1.getPeca().getNumEsquerdo());
			assertEquals(0, j1.getPeca().getNumDireito());
					
			Jogada j2 = estrategia.decideJogada(List.of(new Peca(0, 0), new Peca(0, 1), new Peca(2, 1)), mesa);

			assertEquals(TipoJogada.DIREITA_ESQUERDA, j2.getTipo());
			assertEquals(2, j2.getPeca().getNumEsquerdo());
			assertEquals(1, j2.getPeca().getNumDireito());
	}
	
		@Test
		void testVoltaAUsarPrimeiraEstrategia() {
			List<EstrategiaDeJogo> estrategias = new ArrayList<>();
			estrategias.add(new JogaPrimeiraPossivel());
			estrategias.add(new PriorizarPecaMaiorSoma());
			EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);

			Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 0), new Peca(1, 4)), mesa);

			assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
			assertEquals(2, j1.getPeca().getNumEsquerdo());
			assertEquals(0, j1.getPeca().getNumDireito());
			
			Jogada j2 = estrategia.decideJogada(List.of(new Peca(1, 4), new Peca(2, 6)), mesa);

			assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());
			assertEquals(2, j2.getPeca().getNumEsquerdo());
			assertEquals(6, j2.getPeca().getNumDireito());
			
			Jogada j3 = estrategia.decideJogada(List.of(new Peca(1, 0), new Peca(1, 6)), mesa);

			assertEquals(TipoJogada.NA_ESQUERDA, j3.getTipo());
			assertEquals(1, j3.getPeca().getNumEsquerdo());
			assertEquals(0, j3.getPeca().getNumDireito());
		}
}

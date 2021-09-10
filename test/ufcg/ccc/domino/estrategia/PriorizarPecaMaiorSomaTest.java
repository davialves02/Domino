package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

class PriorizarPecaMaiorSomaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void testPassa() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testJogaPecaMaiorSoma() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(2, 6), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testNaoJogaPecaMaiorSoma() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(2, 6), new Peca(6, 3)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPecaMaiorSomaDireita() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 2), new Peca(2, 6), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPecaMaiorSomaEsquerda() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 2), new Peca(1, 6), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPecaMaiorSomaDireitaEsquerda() {
		PriorizarPecaMaiorSoma estrategia = new PriorizarPecaMaiorSoma();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 0), new Peca(0, 1), new Peca(2, 1)), mesa);

		assertEquals(TipoJogada.DIREITA_ESQUERDA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
}

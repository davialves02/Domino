package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;

class JogaCarrocaPrimeiroTest {
	
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void testPassa() {
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void TestJogaPrimeiraCarroca() {
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 3), new Peca(2, 3), new Peca(2, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void TestNenhumaCarroca() {
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 3), new Peca(1, 3), new Peca(4, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}
	
	@Test
	void TestJogaCarrocaDireita() {
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 1), new Peca(3, 2), new Peca(2, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void TestJogaCarrocaEsquerda() {
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 3), new Peca(2, 3), new Peca(1, 1)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void TestJogaCarrocaDireitaEsquerda() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(2, 3));
		mesa.jogaNaEsquerda(new Peca(1, 3));
		JogaCarrocaPrimeiro estrategia = new JogaCarrocaPrimeiro();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 3), new Peca(2, 3), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.DIREITA_ESQUERDA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());

	}
}

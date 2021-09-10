package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.PecaPadraoComparator;
import ufcg.ccc.domino.Jogada.TipoJogada;

class JogaPrimeiraPossivelComparadoraTeste {
	
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void testPassa() {
		Comparator<Peca> cmp = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testJogaMenor() {
		Comparator<Peca> cmp = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 6), new Peca(0, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereDireitaMenor() {
		Comparator<Peca> cmp = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 5), new Peca(2, 2)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaNaEsquerdaMenor() {
		Comparator<Peca> cmp = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(1, 6), new Peca(1, 4)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPecaDireitaEsquerdaMenor() {
		Comparator<Peca> cmp = new PecaPadraoComparator();
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 6), new Peca(2, 1)), mesa);

		assertEquals(TipoJogada.DIREITA_ESQUERDA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
}

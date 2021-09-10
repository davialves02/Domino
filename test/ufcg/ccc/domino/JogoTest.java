package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Normal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals("normal", j.getTipoVitoria());
	}
	
	@Test
	void testVencedorJ1Carroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(2, 2));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals("carroça", j.getTipoVitoria());
	}
	
	@Test
	void testVencedorJ1LaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(4, 0), new Peca(4, 2));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals("laELo", j.getTipoVitoria());
	}
	
	@Test
	void testVencedorJ1Cruzado() throws Exception {
		List<Peca> mao1 = List.of(new Peca(4, 0), new Peca(2, 4), new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3), new Peca(5, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals("cruzada", j.getTipoVitoria());
	}
	
	@Test
	void testVencedorJ1NumPecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(1, 6), new Peca(4, 3));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5), new Peca(2, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testVencedorJ1SomaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(5, 5));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(5, 6), new Peca(2, 3));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5), new Peca(2, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2Normal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals("normal", j.getTipoVitoria());
	}
	
	@Test
	void testVitoriaJ2Carroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 1));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals("carroça", j.getTipoVitoria());
	}
	
	@Test
	void testVitoriaJ2LaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 6), new Peca(4, 5));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2), new Peca(2, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals("laELo", j.getTipoVitoria());
	}
	
	@Test
	void testVitoriaJ2Cruzada() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 6), new Peca(4, 5));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 6), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals("cruzada", j.getTipoVitoria());
	}
	
	@Test
	void testVencedorJ2NumPecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(5, 6), new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(0, 3), new Peca(2, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	
	@Test
	void testVencedorJ2SomaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(5, 6), new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(3, 3), new Peca(2, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
}

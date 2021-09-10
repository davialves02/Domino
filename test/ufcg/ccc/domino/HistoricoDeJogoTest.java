package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class HistoricoDeJogoTest {
	
	@Test
	void JogaJogoJ1VencedorNormalTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J1",historico.getVencedor());
		assertEquals("normal", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ2VencedorNormalTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J2",historico.getVencedor());
		assertEquals("normal", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ1VencedorCarrocaTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(2, 2));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J1",historico.getVencedor());
		assertEquals("carroça", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ2VencedorCarrocaTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(2, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J2",historico.getVencedor());
		assertEquals("carroça", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ1VencedorLaELoTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 3), new Peca(3, 2));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J1",historico.getVencedor());
		assertEquals("laELo", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ2VencedorLaELoTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 3), new Peca(4, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(3, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J2",historico.getVencedor());
		assertEquals("laELo", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ1VencedorCruzadaTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(0, 2), new Peca(2, 5), new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(4, 0), new Peca(5, 4), new Peca(5, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J1",historico.getVencedor());
		assertEquals("cruzada", historico.getTipoPontuacao());
	}
	
	@Test
	void JogaJogoJ2VencedorCruzadaTest() throws EstrategiaInvalidaException, JogadaInvalidaException {
		List<Peca> mao1 = List.of(new Peca(4, 0), new Peca(2, 3), new Peca(5, 6));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(3, 4), new Peca(4, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		HistoricoDeJogo historico = j.jogaJogoCompleto();
		assertEquals("J2",historico.getVencedor());
		assertEquals("cruzada", historico.getTipoPontuacao());
	}
}

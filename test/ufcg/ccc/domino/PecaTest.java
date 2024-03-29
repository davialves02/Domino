package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PecaTest {


	@Test
	void testGetNumDireito() {
		assertEquals(1, (new Peca(6, 1)).getNumDireito());
		assertEquals(3, (new Peca(3, 3)).getNumDireito());
	}

	@Test
	void testGetNumEsquerdo() {
		assertEquals(6, (new Peca(6, 1)).getNumEsquerdo());
		assertEquals(3, (new Peca(3, 3)).getNumEsquerdo());
	}
	
	@Test
	void testGetSoma() {
		assertEquals(7, (new Peca(6, 1)).getSoma());
		assertEquals(6, (new Peca(3, 3)).getSoma());
	}
	
	@Test
	void testEhCarroca() {
		assertTrue(new Peca(6, 6).ehCarroca());
		assertTrue(new Peca(0, 0).ehCarroca());
	}

	@Test
	void testGira() {
		Peca peca = new Peca(6, 1); 
		
		peca.gira();
		assertEquals(6, peca.getNumDireito());
		assertEquals(1, peca.getNumEsquerdo());
		
		peca.gira();
		assertEquals(1, peca.getNumDireito());
		assertEquals(6, peca.getNumEsquerdo());
	}
	
	@Test
	void testToString() throws Exception {
		assertEquals("6:1", (new Peca(6, 1)).toString());
		assertEquals("3:3", (new Peca(3, 3)).toString());
	}
}

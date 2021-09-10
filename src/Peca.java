package ufcg.ccc.domino;

/**
 * Uma peça de dominó com dois lados.
 *
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;
	private boolean carroca;
	/**
	 * Soma do lado direito e esquerdo da peça.
	 */
	private int soma;

	/**
	 * Cria uma peça.
	 * 
	 * @param numEsquerdo Número do lado esquerdo.
	 * @param numDireito  Número do lado direito.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
		this.soma = numEsquerdo + numDireito;
		if(numEsquerdo == numDireito) {
			this.carroca = true;
		} else {
			this.carroca = false;
		}
	}

	/**
	 * Inverte os lados dos números na peça.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O número da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O número da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}
	
	/**
	 * @return Se a peça é uma carroça.
	 */
	public boolean ehCarroca() {
		return carroca;
	}
	
	/**
	 * 
	 * @return A soma da peça.
	 */
	public int getSoma() {
		return soma;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a peça encaixa com um número.
	 * 
	 * @param numero O número a testar.
	 * @return true se um dos lados ao menos combinar com o númer.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}

}

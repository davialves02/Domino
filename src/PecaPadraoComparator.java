package ufcg.ccc.domino;

import java.util.Comparator;

public class PecaPadraoComparator implements Comparator<Peca> {

	@Override
	public int compare(Peca peca1, Peca peca2) {
		if(peca1.getNumEsquerdo() - peca2.getNumEsquerdo() == 0) {
			return peca1.getNumDireito() - peca2.getNumDireito();
		}else {
			return peca1.getNumEsquerdo()-peca2.getNumEsquerdo();
		}
	}
}

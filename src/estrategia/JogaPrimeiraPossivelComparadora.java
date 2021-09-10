package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

public class JogaPrimeiraPossivelComparadora implements EstrategiaDeJogo {
	private Comparator<Peca> cmp;
	
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> comparator) {
		this.cmp = comparator;
	}
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		ArrayList<Peca> maoCmp = new ArrayList<Peca>();
		
		for(Peca peca: mao) {
			maoCmp.add(peca);
		}
		
		Collections.sort(maoCmp,cmp);
		
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivel();
		
		return  estrategia.decideJogada(maoCmp, mesa);
	}
	
}

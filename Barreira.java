package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Barreira extends Elemento {
	
	

	@Override
	public void atualiza() {
	}

	@Override
	public void desenha(Graphics2D g) {

		int larg = getLargura();

		setLargura(80);
		setAltura(15);
		g.setColor(Color.GRAY);	
		g.fillRect(getPx(), getPy(), larg, getAltura());

	}	
}
package br.characters;

import java.awt.Color;
import java.awt.Graphics;

public class Shot {

	private int x, y, velocity = 10, sizeX = 15, sizeY = 15;
	
	//CONSTRUTOR
	public Shot(int inicioX, int inicioY) {
		this.x = inicioX;
		this.y = inicioY;
	}
	
	public void print(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, sizeX, sizeY);
	}
	
	public void move() {
		y -= velocity;
	}
}

/*
	public boolean destroy() {
		return y < 0; //retornar verdadeiro ou falso	
	}

	public boolean colideCom(Inimigo inimigo) {
		if ( x >= inimigo.getX() && x + tamX <= inimigo.getX() + inimigo.getTam() ) {
			if (y <= inimigo.getY() + inimigo.getTam()) {
				return true;
			}
		}
		return false;
	}
}
*/

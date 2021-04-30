package br.characters;

import java.awt.Color;
import java.awt.Graphics;

public class Shot {

	private int x, y, velocity, sizeX = 15, sizeY = 15;
	
	//CONSTRUTOR
	public Shot(int inicioX, int inicioY) {
		
		this.x = inicioX;
		this.y = inicioY;
		velocity = 10;
	}
	
	public void print(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, sizeX, sizeY);
	}
}

/*
import java.awt.Color;
import java.awt.Graphics2D;

public class Tiro {


	public void atualiza() {
		y -= velocidade;
	}
	
	
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

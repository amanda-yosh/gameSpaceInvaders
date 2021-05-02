package br.characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import br.Game;

public class Shot {

	private int x, y; //POSICAO
	private static int velocity = 7;
	private int width = 15, height = 10; //LARGURA E ALTURA DO TIRO
	private static boolean isVisible = false; //TIRO DEIXARÁ DE SER VISIVEL QUANDO COLIDIR COM OUTRO OBJETO
	
	//CONSTRUTOR
	public Shot(int inicioX, int inicioY) {
		this.x = inicioX;
		this.y = inicioY;
	}
	
	public void print(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	public void move() {
		y -= velocity;
		if (y > Game.HEIGHT) {
			isVisible = false;
		}
	}

	public static int getVelocity() {
		return velocity;
	}

	public static void setVelocity(int velocity) {
		Shot.velocity = velocity;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public static void setVisible(boolean isVisible) {
		Shot.isVisible = isVisible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//CRIANDO UM RETANGULO EM VOLTA DO OBJETO
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
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

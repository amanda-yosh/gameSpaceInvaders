package br.characters;

import java.awt.Color;
import java.awt.Graphics;

public class Alien {

	//private BufferedImage desenho;
	private int x;
	private int y;
	private float velocity;
	private int direction;
	
	//CONSTRUTOR
	public Alien(/*BufferedImage imagem,*/ int inicioX, int inicioY, int direction) {
		
		//this.desenho = imagem;
		
		this.x = inicioX;
		this.y = inicioY;
		this.direction = direction;
		
		this.velocity = 2;
	}
	
	public void update() {
		x += velocity * direction;
	}
	
	public void print(Graphics g) {
		//g.drawImage(desenho, x, y, x + 50, y + 50, 0, 0, desenho.getWidth(), desenho.getHeight(), null);
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 50, 50);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

/*
public class Inimigo {

	public void trocaDirecao() {
		
		direcao = direcao * -1;
		y += 25;
		velocidade += 0.25f;
	}
	
	public int getTam() {
		
		return 50;
	}
} 
*/

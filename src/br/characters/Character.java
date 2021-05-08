package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Character {

	//POSIÇÃO
	protected int y;
	protected int x;
	
	//IMAGEM
	protected BufferedImage img = null;
	
	public void load() {
		//CARREGAR A IMAGEM
	}
	
	public void paint(Graphics g) {
		//PINTAR A IMAGEM NA TELA
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//MOVIMENTO DO OBJETO
	public void update() {}
	
	//CRIANDO UM RETANGULO EM VOLTA DO OBJETO PARA COLISÃO
	public Rectangle getBounds() {
		return new Rectangle(x, y, x /* + img.getWidth*/, y /* + img.getHeight*/);
	}
}

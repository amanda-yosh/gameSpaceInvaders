package br.characters;

import java.awt.image.BufferedImage;

public class Character {

	//POSIÇÃO
	protected int y;
	protected int x;
	
	//IMAGEM
	protected BufferedImage img = null;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

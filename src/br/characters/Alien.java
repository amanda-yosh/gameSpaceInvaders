package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Alien extends Character {

	private int movex = 7;
	private boolean isVisible;
	
	//CONSTRUTOR
	public Alien(int inicioX, int inicioY) {
		this.load();

		this.x = inicioX;
		this.y = inicioY;
		
		isVisible = true;
	}
	
	@Override
	public void load() {
		try {
			img = ImageIO.read(new File("src/space-green-alien.png"));
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel carregar a imagem do alien");
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		x += movex;
		limits();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, x + 50, y + 50, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 50);
	}
	
	public void limits() {
		//MARGIN RIGHT
		if (x + 50 > Game.WIDTH) {
			movex = -3;
			y += 100;
		}
		//MARGIN LEFT
		if (x < 0) {
			movex = 3;
			y += 100;
		}
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
}
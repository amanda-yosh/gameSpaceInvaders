package br.characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Shot extends Character {

	private static int velocity = 7;
	private int width = 3, height = 20; //LARGURA E ALTURA DO TIRO
	private static boolean isVisible = false; //TIRO DEIXARÁ DE SER VISIVEL QUANDO COLIDIR COM OUTRO OBJETO
	
	//CONSTRUTOR
	public Shot(int inicioX, int inicioY) {
		try {
			img = ImageIO.read(new File("src/pinkShot.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
		
		this.x = inicioX;
		this.y = inicioY;
	}
	
	public void print(Graphics g) {
		g.drawImage(img, x, y, x + width, y + 20, 0, 0, img.getWidth(), img.getHeight(), null);
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

	
	//CRIANDO UM RETANGULO EM VOLTA DO OBJETO
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	
}

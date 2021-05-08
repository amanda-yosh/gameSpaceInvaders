package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Shot extends Character {

	private static int velocity = 7;
	private int width = 6, height = 20; //LARGURA E ALTURA DO TIRO
	private static boolean isVisible = false; //TIRO DEIXARÁ DE SER VISIVEL QUANDO COLIDIR COM OUTRO OBJETO
	
	//CONSTRUTOR
	public Shot(int inicioX, int inicioY) {
		this.load();
		
		//TIRO VAI SAIR DA POSIÇÃO DO PLAYER
		this.x = inicioX;
		this.y = inicioY;
		
		isVisible = true;
	}
	
	@Override
	public void load() {
		try {
			img = ImageIO.read(new File("src/pinkShot.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, x + width, y + 20, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	@Override
	public void update() {
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

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	
}

package br.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Alien {

	private BufferedImage img = null;
	private int x;
	private int y;
	private float velocity = 2;
	private int direction;
	
	//CONSTRUTOR
	public Alien(int inicioX, int inicioY, int direction) {
		try {
			img = ImageIO.read(new File("src/space-green-alien.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem do alien");
			e.printStackTrace();
		}

		this.x = inicioX;
		this.y = inicioY;
		this.direction = direction;
		
		//this.velocity = 2;
	}
	
	public void update() {
		x += velocity * direction;
	}
	
	public void print(Graphics g) {
		g.drawImage(img, x, y, x + 50, y + 50, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		//return img.getHeight(); //DEU 443 DE RETORNO, IMPOSSIVEL!!!
		return 50;
	}
	
	public void chaceDirection() {
		direction = direction * -1;
		y += 25;
		velocity += 0.25f;
	}
}
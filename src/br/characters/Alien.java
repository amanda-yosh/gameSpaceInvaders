package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Alien {

	private BufferedImage img = null;
	private int x, movex = 3;
	private int y;
	
	//CONSTRUTOR
	public Alien(int inicioX, int inicioY) {
		try {
			img = ImageIO.read(new File("src/space-green-alien.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem do alien");
			e.printStackTrace();
		}

		this.x = inicioX;
		this.y = inicioY;
	}
	
	public void update() {
		x += movex;
		limits();
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
	
	//CRIANDO UM RETANGULO EM VOLTA DO OBJETO
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, getHeight());
	}
	
	public void limits() {
		//MARGIN RIGHT
		if (x + 50 > Game.WIDTH) {
			movex = -3;
		}
		//MARGIN LEFT
		if (x < 0) {
			movex = 3;
		}
	}
}
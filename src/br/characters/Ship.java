package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import br.Game;

public class Ship {

	private BufferedImage img = null;
	private int x = 400; //Game.WIDTH
	private int movex = 6; //VELOCIDADE DE MOVIMENTACAO DO OBJETO
	private ArrayList<Shot> shots; //PARA ALOCAR UMA QUANTIDADE DESCONHECIDA DE TIROS
	
	//CONSTRUTOR
	public Ship() {
		try {
			img = ImageIO.read(new File("src/space-ship.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
		
		shots = new ArrayList<Shot>();
	}
	
	public void print(Graphics g) {
		g.drawImage(img, x, Game.HEIGHT - 150, x + 100, Game.HEIGHT - 150 + 100, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	public void moveShip(int valor) {
		if (valor == 1) {
			x += movex; // >>>
		} else if (valor == -1) {
			x -= movex; // <<<
		}
		
		limits();
	}
	
	public void limits() {
		//MARGIN RIGHT
		if (x + 100 > Game.WIDTH) {
			x = 700;
		}
		//MARGIN LEFT
		if (x < 0) {
			x = 0;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return Game.HEIGHT - 150; //NÃO SE MOVE EM Y
	}
	
	public int getShipWidth() {
		return 100; //img.getWidth();
	}
	
	//CRIANDO UM RETANGULO EM VOLTA DO OBJETO
	public Rectangle getBounds() {
		return new Rectangle(x, getY(), getShipWidth(), getY());
	}
	
	public void simpleShot() {
		this.shots.add(new Shot(this.getX() + this.getShipWidth(), this.getY()));
		Shot.setVisible(true);
		
	}
	
	public ArrayList<Shot> getShots() {
		return shots;
	}
}
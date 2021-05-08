package br.characters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import br.Game;

public class Ship extends Character {

	private int movex = 6; //VELOCIDADE DE MOVIMENTACAO DO OBJETO
	private List<Shot> shots; //PARA ALOCAR UMA QUANTIDADE DESCONHECIDA DE TIROS
	
	//CONSTRUTOR
	public Ship() {
		this.load();
		
		this.x = Game.WIDTH/2;
		
		shots = new ArrayList<Shot>();
	}
	
	@Override
	public void load() {
		try {
			img = ImageIO.read(new File("src/space-ship.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
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
	
	@Override
	public int getY() {
		return Game.HEIGHT - 150; //NÃO SE MOVE EM Y
	}
	
	public int getShipWidth() {
		return 100; //img.getWidth();
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, getY(), getShipWidth(), getY());
	}
	
	public void simpleShot() {
		this.shots.add(new Shot(this.getX(), this.getY()));
		//Shot.setVisible(true);
		
	}
	
	public List<Shot> getShots() {
		return shots;
	}
}
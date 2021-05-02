package br.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Ship {

	private BufferedImage img = null;
	private int x;
	private int movex = 6; //VELOCIDADE DE MOVIMENTACAO DO OBJETO
	//private boolean canShot;
	//private int recharge;
	
	//CONSTRUTOR
	public Ship() {
		try {
			img = ImageIO.read(new File("src/space-ship.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
		
		x = 400;
		//canShot = true;
		//recharge = 0;
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
		
		/*if (recharge >= 10) {
			canShot = true;
			recharge = 0;
		}
		recharge++;*/
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
		return Game.HEIGHT - 150;
	}
}

/*
	//a nave retorna um tiro na posição em que ela está
	public Tiro atirar() {
		podeAtirar = false;
		recarregando = 0;
								//49 - é o meio da nave
		Tiro novoTiro = new Tiro(x + 49, MainJogo.monitor.getHeight() - 150);
		return novoTiro;
	}
	
	public void movimenta(int valor) {
		
		//se valor for negativo <<<<
		//se for positivo  >>>>
		if (valor == 1) {
			x += velocidade;
		} else if (valor == -1) {
			x -= velocidade;
		}
		
		if (recarregando >= 10) {
			podeAtirar = true;
			recarregando = 0;
		}
		
		recarregando++;
	}
	
	public boolean podeAtirar() {
		return podeAtirar;
	}
*/
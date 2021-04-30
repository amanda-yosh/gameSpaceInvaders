package br.characters;

import java.awt.Color;
import java.awt.Graphics;

public class Ship {

	//private BufferedImage desenho;
	private int x;
	private int velocity;
	private boolean canShot;
	private int recharge;
	
	//CONSTRUTOR
	public Ship() {
		/*try {
			desenho = ImageIO.read(new File("imagens/nave.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}*/
		
		x = 683;
		velocity = 3;
		canShot = true;
		recharge = 0;
	}
	
	public void print(Graphics g) {
		//posX posY: são para a tela, tamX tamY são da imagem original
		//imagem  posX posY    tamX tamY	//toda a imagem
		/*g.drawImage(
				desenho,										// a imagem a ser desenhada 
				x, MainJogo.monitor.getHeight() - 150, 			// posicao x e y da imagem
				x + 100, MainJogo.monitor.getHeight() - 150 + 100,  //tamanho da imagem
				0, 0, 												//canto da imagem original
				desenho.getWidth(), desenho.getHeight(), 			//tamanho da imagem original
				null);*/
		g.setColor(Color.BLUE);
		g.fillRect(x, 40, 50, 50);
	}
	
	public void moveShip(int valor) {
		
		//se valor for negativo <<<<
		//se for positivo  >>>>
		if (valor == 1) {
			x += velocity;
		} else if (valor == -1) {
			x -= velocity;
		}
		
		if (recharge >= 10) {
			canShot = true;
			recharge = 0;
		}
		recharge++;
	}
}

/*
public class Nave {
	
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
	
}
*/
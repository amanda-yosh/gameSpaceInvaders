package br.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Collision {

	private BufferedImage img;
	private int x, y;
	private float duracao;
	private int animacaoTotal;
	private int linha;
	private int coluna;
	
	//CONSTRUTOR
	public Collision(int x, int y) {
		try {
			img = ImageIO.read(new File("src/collision.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem da explosão");
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		
		animacaoTotal = 30;
		duracao = 0;
		
		linha = 0;
		coluna = 0;
	}
	
	public void print(Graphics g) {
		
		g.drawImage(img, x, y, x + 50, y + 50, 192 * coluna, 192 * linha, 192 * coluna + 192, 192 * linha + 192, null);
		
	}
}

/*
	public void atualizar() {
		
		duracao += 1f;
		
		linha = ((int)duracao) / 6;
		coluna =((int)duracao) % 5;
		
	}
	
	public boolean acabou() {
		if (duracao >= animacaoTotal)
			return true;
			
		return false;
	}
*/
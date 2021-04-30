package br.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import br.Game;
import br.characters.Alien;
import br.characters.Shot;

public class MenuState implements State{
	
	private String[] options = { "START", "HELP", "EXIT" };
	private Font font1, font2;
	private int choice = 0;
	private int x = 0, y = 0, movex = 1, movey = 1;
	
	private Shot shot;
	//private Alien alien;

	@Override
	public void init() {
		font1 = new Font("Dialog", Font.PLAIN, 48);
		font2 = new Font("Dialog", Font.PLAIN, 24);
	}

	@Override
	public void update() {
		x += movex;
		y += movey;
		
		limits();
	}

	private void limits() {
		if (x > Game.WIDTH) {
			movex = -1;
		}
		if (y > Game.HEIGHT) {
			movey = -1;
		}
		if (x < 0) {
			movex = 1;
		}
		if (y < 0) {
			movey = 1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.setFont(font1);
		String text = "Space Invaders";
		g.drawString(text,
				Game.WIDTH/2 - g.getFontMetrics().stringWidth(text)/2,
				Game.HEIGHT * 1/4);
		
		g.setFont(font2);
		for (int i = 0; i < options.length; i++) {
			g.setColor(Color.WHITE);
			if (i == choice) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(options[i],
					Game.WIDTH/2 - g.getFontMetrics().stringWidth(options[i])/2,
					 Game.HEIGHT * 3/4 + g.getFontMetrics(font2).getHeight() * i);
		}
		
		shot = new Shot(x, y);
		shot.print(g);
		//alien = new Alien(x+50, y+50, 100);
		//alien.print(g);
		

	}

	//METODOS ONDE ACONTECE A INTERACAO
	@Override
	public void KeyPress(int cod) {
		
	}

	@Override
	public void KeyReleased(int cod) {
		if (cod == KeyEvent.VK_W) {
			choice--;
			if (choice < 0) {
				choice = options.length - 1;
			}
		}
		if (cod == KeyEvent.VK_S) {
			choice++;
			if (choice > options.length - 1) {
				choice = 0;
			}
		}
		if (cod == KeyEvent.VK_ENTER) {
			select();
		}
	}

	private void select() {
		switch (choice) {
		case 0:
			StateManager.setState(StateManager.FPS);
			break;
		case 1:
			break;
		case 2:
			System.exit(0);
			break;
		default:
			break;
		}
	}

}

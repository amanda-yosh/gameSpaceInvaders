package br.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.Game;

public class MenuState implements State{
	
	private Font font1, font2;
	private int choice = 0;
	private String[] options = { "START", "HELP", "EXIT" };

	@Override
	public void init() {
		font1 = new Font("Dialog", Font.PLAIN, 48);
		font2 = new Font("Dialog", Font.PLAIN, 24);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
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
	}

	@Override
	public void KeyPress(int cod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(int cod) {
		// TODO Auto-generated method stub
		
	}

}

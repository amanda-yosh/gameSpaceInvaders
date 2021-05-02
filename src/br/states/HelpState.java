package br.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import br.Game;
import br.display.Background;

public class HelpState implements State {

	private String[] options = { "RETURN", "EXIT" };
	private Font font2;
	private int choice = 0;
	
	private Background background;
	
	@Override
	public void init() {
		font2 = new Font("Dialog", Font.PLAIN, 24);
	}

	@Override
	public void update() {}

	@Override
	public void render(Graphics g) {
		background = new Background();
		background.print(g);
		
		g.setFont(font2);
		g.setColor(Color.WHITE);
		String text = "ALIENS ENVADIRAM A VIA LÁCTEA";
		g.drawString(text,
				Game.WIDTH/2 - g.getFontMetrics().stringWidth(text)/2,
				Game.HEIGHT * 1/10);
		text = "E ESTÃO A CAMINHO DA TERRA,";
		g.drawString(text,
				Game.WIDTH/2 - g.getFontMetrics().stringWidth(text)/2,
				Game.HEIGHT * 2/10);
		text = "DESTRUA-OS ANTES QUE SEJA TARDE DEMAIS! ";
		g.drawString(text,
				Game.WIDTH/2 - g.getFontMetrics().stringWidth(text)/2,
				Game.HEIGHT * 3/10);
		
		for (int i = 0; i < options.length; i++) {
			g.setColor(Color.WHITE);
			if (i == choice) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(options[i],
					Game.WIDTH/2 - g.getFontMetrics().stringWidth(options[i])/2,
					 Game.HEIGHT * 3/4 + g.getFontMetrics(font2).getHeight() * i); //+ FONTMETRICS X A ALTURA PARA ESPAÇAR AS OPÇÕES
		}
	}

	@Override
	public void KeyPressed(int cod) {}

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
			StateManager.setState(StateManager.MENU);
			break;
		case 1:
			System.exit(0);
			break;
		default:
			break;
		}	
	}

}

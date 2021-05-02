package br.states;

import java.awt.Graphics;

import br.Game;
import br.characters.Alien;
import br.characters.Ship;
import br.display.Background;
import br.input.KeyManager;

public class Level1State implements State {
	
	private Ship ship;
	private Alien alien;
	private Background background;

	@Override
	public void init() {
		ship = new Ship();
		alien = new Alien(Game.WIDTH/2, Game.HEIGHT * 1/4, -1);
	}
	
	public void start() {
		alien.update();
	}

	@Override
	public void update() {
		//INTERACAO DO USUARIO
		//QUERO PARA DIREITA SUBTRAIR, ESQUERDA SOMAR
		if (KeyManager.a || KeyManager.left) {
			ship.moveShip(-1); //-1 PARA <<<
		}
		if (KeyManager.d || KeyManager.right) {
			ship.moveShip(1); //1 PARA >>>
		}
	}

	@Override
	public void render(Graphics g) {
		background = new Background();
		background.print(g);
		

		alien.print(g);
		ship.print(g);
		start();
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

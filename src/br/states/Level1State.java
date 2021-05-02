package br.states;

import java.awt.Graphics;
import java.util.ArrayList;

import br.Game;
import br.characters.Alien;
import br.characters.Ship;
import br.characters.Shot;
import br.display.Background;
import br.input.KeyManager;

public class Level1State implements State {
	
	private Ship ship;
	private Alien alien;
	private Background background;
	private ArrayList<Shot> shots;

	@Override
	public void init() {
		ship = new Ship();
		alien = new Alien(Game.WIDTH/2, Game.HEIGHT * 1/4);
		shots = ship.getShots(); //PEGANDO A LISTA DE TIROS
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
		if (KeyManager.space) {
			ship.simpleShot();
		}
	}

	@Override
	public void render(Graphics g) {
		background = new Background();
		background.print(g);
		
		ship.print(g);

		alien.print(g);
		start();
		
		for (int i = 0; i < shots.size(); i ++) {
			Shot s = shots.get(i);
			if (s.isVisible() == true) {
				s.print(g);
				s.move();
			}
			else {
				//destuir
			}
		}
	}
	
	public void collisionCheck() {
		
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

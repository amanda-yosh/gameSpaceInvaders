package br.states;

import java.awt.Graphics;
import java.util.ArrayList;

import br.Game;
import br.characters.Alien;
import br.characters.Ship;
import br.characters.Shot;
import br.display.Background;
import br.input.KeyManager;

public class Level2State implements State {
	
	
	private Ship ship;
	private Shot shot;
	private Background background;
	private ArrayList<Alien> aliens;
	private Alien alien;
	//private ArrayList<Shot> shots;
	//private ArrayList<Collision> collisions;
	

	@Override
	public void init() {
		ship = new Ship();
		//shots = new ArrayList<Shot>();
		aliens = new ArrayList<Alien>();
		//collisions = new ArrayList<Collision>();
		
		
		//POPULANDO O ARRAY
		for (int i = 0; i <= Game.WIDTH; i += Game.WIDTH/8) {
			aliens.add(new Alien((Game.WIDTH * i)/10, Game.HEIGHT * 1/4));
		}
		
		//start();
	}
	
	public void start() {
		//alien.update();
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
		/*if (KeyManager.space) {
			shot = new Shot(ship.getX(), ship.getY());
			
		}*/
	}

	@Override
	public void render(Graphics g) {
		background = new Background();
		background.print(g);
		
		
		//
		for (int i = 0; i <= Game.WIDTH; i += Game.WIDTH/8) {
			aliens.get(i).print(g);
		}

		ship.print(g);
		if (KeyManager.space) {
			shot = new Shot(ship.getX(), ship.getY());
			shot.print(g);
		}
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

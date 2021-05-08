package br.states;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import br.Game;
import br.characters.Alien;
import br.characters.Ship;
import br.characters.Shot;
import br.display.Background;
import br.input.KeyManager;

public class Level1State implements State {
	
	private Ship ship;
	private List<Shot> shots;
	private Alien alien;
	private Background background;
	
	//private boolean emJogo;
	private boolean victory;
	private boolean gameOver;

	@Override
	public void init() {
		//INSTANCIANDO O SHIP
		ship = new Ship();
		
		//PEGANDO A LISTA DE TIROS
		shots = ship.getShots();
		
		//INSTANCIANDO O ALIEN
		alien = new Alien(Game.WIDTH/2, Game.HEIGHT * 1/4);
		
		//emJogo = true;
		victory = false;
		gameOver = false;
	}

	@Override
	public void update() {
		//INTERACAO DO USUARIO
		if (KeyManager.a) {
			ship.moveShip(-1); //-1 PARA <<<
		}
		if (KeyManager.d) {
			ship.moveShip(1); //1 PARA >>>
		}
		if (KeyManager.space) {
			ship.simpleShot();
		}
	}

	@Override
	public void render(Graphics g) {
		
		//if (emJogo == true) {
			background = new Background();
			background.print(g);
			
			//DESENHANDO O SHIP
			ship.paint(g);

			//DESENHANDO O ALIEN
			alien.paint(g);
			
			//MOVIMENTACAO DO ALIEN
			alien.update();
			
			//DESENHANDO E MOVIMENTANDO OS TIROS
			for (int e = 0; e < shots.size(); e++) {
				Shot s = shots.get(e);
				if (s.isVisible()) {
					s.paint(g);
					s.update();
				}
				else {
					shots.remove(e);
				}
			}
			checarColisoes();
		//}
		if (victory == true) {
			//YouWinState CASO victory == true
			StateManager.setState(StateManager.YOUWIN);
		}
		//else {
		if (gameOver == true) {
			//GameOverState CASO emJogo == false
			StateManager.setState(StateManager.GAMEOVER);
		}
	}
	
	private void checarColisoes() {
		Rectangle formaShip = ship.getBounds();
		Rectangle formaAlien = alien.getBounds();
		Rectangle formaShot;
		
		//COLISAO ENTRE O SHIP E O ALIEN
		if (formaShip.intersects(formaAlien)) {
			//emJogo = false;
			gameOver = true;
		}
		
		//COLISAO ENTRE O SHOT E O ALIEN
		List<Shot> shots = ship.getShots();
		for (int i = 0; i < shots.size(); i++) {
			Shot tempShot = shots.get(i);
			formaShot = tempShot.getBounds();
			if (formaShot.intersects(formaAlien)) {
				victory = true;
			}
		}
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

package br.states;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
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
	private static int qtdAliens = 8;

	@Override
	public void init() {
		//INSTANCIANDO O SHIP
		ship = new Ship();
		
		//PEGANDO A LISTA DE TIROS
		shots = ship.getShots();
		
		//INSTANCIANDO O ALIEN
		alien = new Alien(Game.WIDTH/2, Game.HEIGHT * 1/4);
	}

	@Override
	public void update() {
		//INTERACAO DO USUARIO
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
			
			//DESENHANDO O SHIP
			ship.print(g);

			//DESENHANDO O ALIEN
			alien.print(g);
			
			//MOVIMENTACAO DO ALIEN
			alien.update();
			
			//DESENHANDO E MOVIMENTANDO OS TIROS
			for (int e = 0; e < shots.size(); e++) {
				Shot s = shots.get(e);
				if (s.isVisible()) {
					s.move();
				}
				else {
					shots.remove(e);
				}
			}
			
			
			checarColisoes();
		}
		//else {
			//GAMEOVER CASO atGame == false
			//StateManager.setState(StateManager.GAMEOVER);
		//}
	//}
	
	private void checarColisoes() {
		Rectangle formaShip = ship.getBounds();
		Rectangle formaAlien = alien.getBounds();
		Rectangle formaTiro;
		
		//COLISAO ENTRE O SHIP E O ALIEN
		if (formaShip.intersects(formaAlien)) {
			StateManager.setState(StateManager.GAMEOVER);
		}
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

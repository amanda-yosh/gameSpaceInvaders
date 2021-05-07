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

public class Blabla implements State {
	
	private Ship ship;
	private List<Alien> aliens;
	private Background background;
	private static int qtdAliens = 8;
	private boolean atGame = false;

	@Override
	public void init() {
		//INSTANCIANDO O SHIP
		ship = new Ship();
		
		//O GAME ESTÁ ACONTECENDO
		this.atGame = true;
	}
	
	public void start() {
		for (int b = 0; b < qtdAliens; b ++) {
			aliens.get(b).update();
		}
	}
	
	public void instanciandoInimigos() {
		aliens = new ArrayList<Alien>();
		for (int a = 0; a < qtdAliens; a ++) {
			aliens.add(new Alien((Game.WIDTH * (1 + a))/10, Game.HEIGHT * 1/6));
		}
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
		
		//MOVIMENTAÇÃO DO SHOT
		List<Shot> tiros = ship.getShots();
		for (int e = 0; e < tiros.size(); e++) {
			Shot s = tiros.get(e);
			if (s.isVisible()) {
				s.move();
			}
			else {
				tiros.remove(e);
			}
		}
		
		//MOVIMENTAÇÃO DO ALIEN
		for (int f = 0; f < aliens.size(); f++) {
			if (aliens.get(f).isVisible()) {
				aliens.get(f).update();
			}
			else {
				aliens.remove(f);
			}
		}
		checarColisoes();
	}

	private void checarColisoes() {
		Rectangle formaPlayer = ship.getBounds();
		Rectangle formaAlien;
		Rectangle formaTiro;
		
		//COLISAO ENTRE O PLAYER E O ALIEN
		for(int g = 0; g < aliens.size(); g++) {
			Alien tempAlien = aliens.get(g);
			formaAlien = tempAlien.getBounds();
			if (formaPlayer.intersects(formaAlien)) {
				ship.setVisible(false);
				tempAlien.setVisible(false);
				atGame = false;
			}
		}
		
		//COLISAO ENTRE O TIRO E O ALIEN
		List<Shot> tiros = ship.getShots();
		for(int j = 0; j < tiros.size(); j++) {
			Shot tempTiro = tiros.get(j);
			formaTiro = tempTiro.getBounds();
			for (int k = 0; k < aliens.size(); k++) {
				Alien tempAlien = aliens.get(k);
				formaAlien = tempAlien.getBounds();
				if (formaTiro.intersects(formaAlien)) {
					tempAlien.setVisible(false);
					tempTiro.setVisible(false);
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		if (atGame == true) {
			background = new Background();
			background.print(g);
			
			//DESENHANDO O SHIP
			ship.print(g);
			
			//DESENHANDO OS SHOTS
			List<Shot> tiros = ship.getShots();
			for (int d = 0; d < tiros.size(); d++) {
				Shot t = tiros.get(d);
				t.print(g);
			}

			//INSTANCIANDO ARRAY DE ALIENS
			instanciandoInimigos();
			
			//DESENHANDO OS ALIENS
			for (int c = 0; c < qtdAliens; c++) {
				aliens.get(c).print(g);
			}
		}
		else {
			//GAMEOVER CASO atGame == false
			StateManager.setState(StateManager.GAMEOVER);
		}
	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

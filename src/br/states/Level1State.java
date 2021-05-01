package br.states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import br.Game;
import br.audio.AudioPlayer;
import br.characters.Alien;
import br.characters.Collision;
import br.characters.Ship;
import br.characters.Shot;
import br.input.KeyManager;

public class Level1State implements State {
	
	
	private Ship ship;
	//private Background background;
	private ArrayList<Alien> aliens;
	private ArrayList<Shot> shots;
	private ArrayList<Collision> collisions;
	
	private AudioPlayer themeSound;
	
	public Level1State() {
		themeSound = new AudioPlayer("/audio/theblackframe.mp3");
	}

	@Override
	public void init() {
		ship = new Ship();
		shots = new ArrayList<Shot>();
		aliens = new ArrayList<Alien>();
		collisions = new ArrayList<Collision>();
		
		//start();
		themeSound.play();
	}
	
	public void start() {
		
	}

	@Override
	public void update() {

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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		//alien = new Alien(imageAlien, Game.WIDTH/2, 0, 0);
		//alien.print(g);
		
		ship.print(g);

	}

	@Override
	public void KeyPressed(int cod) {}

	@Override
	public void KeyReleased(int cod) {}

}

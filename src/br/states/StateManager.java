package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//GUARDARÁ UMA QUANTIDADE DE ESTADOS
public class StateManager implements KeyListener{

	public static final int NUMBERSTATES = 6; //0 1 2 3 4 5
	public static State[] states = new State[NUMBERSTATES]; //ARRAY PARA GUARDAR OS ESTADOS
	public static int currentState = 0;
	
	//PARA A SELEÇÃO DOS ESTADOS DO JOGO EM MENUSTATE
	public static final int MENU = 0;
	public static final int HELP = 1;
	public static final int GAMEOVER = 2;
	public static final int YOUWIN = 3;
	public static final int LEVEL1 = 4;
	public static final int LEVEL2 = 5;
	
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public static State getState() {
		return states[currentState];
	}
	
	public StateManager() {
		//POPULAR O ARRAY INSTANCIANDO OS ESTADOS
		states[0] = new MenuState();
		states[1] = new HelpState();
		states[2] = new GameOverState();
		states[3] = new YouWinState();
		states[4] = new Level1State();
		states[5] = new Level2State();
	}
	
	public void update() {
		states[currentState].update();
	}
	
	public void render(Graphics g) {
		states[currentState].render(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		states[currentState].KeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[currentState].KeyReleased(e.getKeyCode());
	}
}

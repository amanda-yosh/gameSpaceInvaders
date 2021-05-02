package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//GUARDARÁ UMA QUANTIDADE DE ESTADOS
public class StateManager implements KeyListener{

	public static final int NUMBERSTATES = 4; //0 1 2 3
	public static State[] states = new State[NUMBERSTATES]; //ARRAY PARA GUARDAR OS ESTADOS
	public static int currentState = 0;
	
	//PARA A SELEÇÃO DOS ESTADOS DO JOGO EM MENUSTATE
	public static final int FPS = 0;
	public static final int MENU = 1;
	public static final int LEVEL1 = 2;
	public static final int HELP = 3;
	
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public static State getState() {
		return states[currentState];
	}
	
	public StateManager() {
		//POPULAR O ARRAY
		states[0] = new FPSState();
		states[1] = new MenuState();
		states[2] = new Level1State();
		states[3] = new HelpState();
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

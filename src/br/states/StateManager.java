package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//GUARDARÁ UMA QUANTIDADE DE ESTADOS
public class StateManager implements KeyListener{

	public static final int numberStates = 2; //0 
	public static State[] states = new State[numberStates];
	public static int currentState = 0;
	
	public static final int FPS = 0;
	public static final int MENU = 1;
	
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
		states[currentState].KeyPress(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[currentState].KeyReleased(e.getKeyCode());
	}
}

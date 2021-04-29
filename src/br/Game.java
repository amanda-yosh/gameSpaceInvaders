package br;

import java.awt.Graphics;

import br.display.Display;
import br.states.StateManager;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		display = new Display("Space Invaders", 1200, 1000);
	}

	@Override
	public void run() {
		//ELEMENTO QUE SERÁ RODADO NA THREAD SEPARADA
		while(running) {
			System.out.println("Esta rodando");
		}
	}
	
	/*MÉTODOS PARA PODERMOS LIGAR E DESLIGAR A THREAD
	* void start();
	* void stop();
	* utilizando o modificador synchronized
	*/
	public synchronized void start() {
		if (thread != null) return; //SE JÁ EXISTIR UM OBJETO, RETORNAMOS E NÃO INSTANCIAMOS UM NOVO OBJETO
		thread = new Thread(this); //NAO EXISTINDO, INSTANCIAMOS UM E VAI QUERER SABER O TARGET, A CLASSE QUE TEM O MÉTODO RUN, ESTA.
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		if (thread == null) return;
		try {
			thread.join(); //IRA JUNTAR COM A APLICACAO PRINCIPAL
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
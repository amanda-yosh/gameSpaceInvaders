package br;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import br.display.Display;
import br.states.StateManager;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public static final int WIDTH = 800, HEIGHT = 1080;
	
	private StateManager sm;
	
	public Game() {
		display = new Display("Space Invaders", WIDTH, HEIGHT);
		sm = new StateManager();
		display.setKeyListener(sm);
		sm.setState(1);
	}

	@Override
	public void run() {
		//ELEMENTO QUE SERÁ RODADO NA THREAD SEPARADA
		
		init();
		int FPS = 60; //60 FRAMES POR SEGUNDO
		double timePerTick = 1000000000 / FPS;//UM TICK É UMA ATUALIZAÇÃO, 1 nanosegundo por 60 frames
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if (delta >= 1) {
				//MOMENTO DE ATUALIZAR A TELA
				update();
				render();
				//System.out.println("FPS = 60\nTempo de atualização: " + delta);
				delta--; //VOLTA A SER 0
			}

		}
		stop();
	}
	
	private void init() {
		
	}
	
	private void update() {
		//Atualizacao a cada interacao do usuario
		if (StateManager.getState() == null) return;
		sm.update();
	}
	
	private void render() {
		//a parte que sera desenhada
		BufferStrategy bs = display.getBufferStrategy();
		if (bs == null) {
			display.createBufferStrategy();
			bs = display.getBufferStrategy();
		}
		
		Graphics g = bs.getDrawGraphics(); //trabalharemo em cima do objeto graphics
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		if (StateManager.getState() != null) {
			sm.render(g); //vai renderizar o desenho passado por cada fase
		}
		
		g.dispose();//disponibilizando para uso
		bs.show();
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
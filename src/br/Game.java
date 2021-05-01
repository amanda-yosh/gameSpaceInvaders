package br;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import br.display.Display;
import br.input.KeyManager;
import br.states.StateManager;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public static final int WIDTH = 800, HEIGHT = 1080;
	
	private StateManager sm;
	private KeyManager km;
	
	public Game() {
		display = new Display("Space Invaders", WIDTH, HEIGHT);
		sm = new StateManager(); //ADMINISTRADOR DE ESTADOS
		km = new KeyManager(); //ADMINISTRADOR DAS ENTRADAS
		display.setKeyListener(sm);
		display.setKeyListener(km);
		StateManager.setState(StateManager.MENU); //INICIALIZA NO MENU
	}

	@Override
	public void run() {
		//ELEMENTO QUE SER� RODADO NA THREAD PARA RENDERIZACAO DA TELA
		
		init();
		int FPS = 60; //60 FRAMES POR SEGUNDO
		double timePerTick = 1000000000 / FPS;//UM TICK � UMA ATUALIZA��O, 1 nanosegundo por 60 frames
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
				//System.out.println("FPS = 60\nTempo de atualiza��o: " + delta);
				delta--; //VOLTA A SER 0
			}
		}
		stop();
	}
	
	private void init() {}
	
	private void update() {
		//ATUALIZA A CADA INTERACAO DO USUARIO
		if (StateManager.getState() == null) return;
		sm.update();
		km.update(); //VERIFICAR O PRESSIONAMENTO DE TECLA A CADA UPDATE
	}
	
	private void render() {
		//REDESENHA
		BufferStrategy bs = display.getBufferStrategy();
		if (bs == null) {
			display.createBufferStrategy();
			bs = display.getBufferStrategy();
		}
		
		Graphics g = bs.getDrawGraphics(); 
		g.clearRect(0, 0, WIDTH, HEIGHT); //LIMPAR A TELA
		
		if (StateManager.getState() != null) {
			sm.render(g); //vai renderizar o desenho passado por cada fase
		}
		
		g.dispose(); //DISPONIBILIZA O GRAFICO
		bs.show(); //DISPLAY DE BUFFER
	}

	/*M�TODOS PARA PODERMOS LIGAR E DESLIGAR A THREAD
	* void start();
	* void stop();
	* utilizando o modificador synchronized
	*/
	public synchronized void start() {
		if (thread != null) return; //SE J� EXISTIR UM OBJETO, RETORNAMOS E N�O INSTANCIAMOS UM NOVO OBJETO
		thread = new Thread(this); //NAO EXISTINDO, INSTANCIAMOS UM E VAI QUERER SABER O TARGET, A CLASSE QUE TEM O M�TODO RUN, ESTA.
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
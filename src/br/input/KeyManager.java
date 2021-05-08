package br.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//PERMITE O PRESSIONAMENTO DE TECLAS SIMULTANEAMENTE
public class KeyManager implements KeyListener {

	//ARRAY DE VERDADEIRO OU FALSO SOBRE AS TECLAS
	private boolean[] keys = new boolean[256];
	
	public static boolean a, d, space;
	
	public void update() {
		a = keys[KeyEvent.VK_A]; //PASSA PARA A VARIÁVEL O VALOR DA CHAVE CORRESPONDENTE A CADA TECLA
		d = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() < 0 || k.getKeyCode() > 255) return; //SE NÃO ESTIVER MAPEADO NO ARRAY, IGNORO/RETORNO
		keys[k.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if (k.getKeyCode() < 0 || k.getKeyCode() > 255) return;
		keys[k.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}

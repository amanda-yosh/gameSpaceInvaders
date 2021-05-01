package br.states;

import java.awt.Graphics;

public interface State {
	void init();
	void update();
	void render(Graphics g); //RECEBERÁ A TELA DE PINTURA E AS FERRAMENTAS PARA DESENHO
	void KeyPressed(int cod);
	void KeyReleased(int cod);
}

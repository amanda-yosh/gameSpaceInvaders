package br.states;

import java.awt.Graphics;

/* M�todos obrigatorios do estado
 * void init();
 * void update();
 * void render(); vai receber a tela de pintura e as ferramentas para desenho, que � o objeto Graphics
 */
public interface State {

	void init();
	void update();
	void render(Graphics g);
	void KeyPress(int cod);
	void KeyReleased(int cod);
}

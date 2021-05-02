package br.characters;

import java.awt.Component;

public class Collision2 {
	
	private boolean collided;

	public boolean hit(Component a, Component b) {
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX + a.getWidth();
		int ladoEsquerdoA = aX;
		int ladoBaixoA = aY + a.getHeight();
		int ladoCimaA = aY;
		
		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX + b.getWidth();
		int ladoEsquerdoB = bX;
		int ladoBaixoB = bY + b.getHeight();
		int ladoCimaB = bY;
		
		boolean cDireita = false;
		boolean cCima = false;
		boolean cBaixo = false;
		boolean cEsquerda = false;
		
		if (ladoDireitoA >= ladoEsquerdoB) {
			cDireita = true;
		}
		if (ladoCimaA >= ladoBaixoB) {
			cCima = true;
		}
		if (ladoBaixoA >= ladoCimaB) {
			cBaixo = true;
		}
		if (ladoEsquerdoA >= ladoDireitoB) {
			cEsquerda = true;
		}
		if (cDireita && cCima && cBaixo && cEsquerda) {
			collided = true;
		}
		return collided;
	}
}

/*
 na minha thread, se minha classe extends JPanel
 	if (collided(alien, shot) == true) {
 	JOptionPane.showMessageDialog(null, "VOCE ACERTOU O ALIEN!");
 	//System.exit(0);
*/
 */
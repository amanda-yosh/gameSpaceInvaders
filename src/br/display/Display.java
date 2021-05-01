package br.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Display {

	private JFrame jframe;
	private Canvas canvas;
	//private JLabel background;
	//private int height;
	
	public Display(String title, int width, int height) {
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		//this.height = height;
		
		//background = new JLabel(new ImageIcon("src\\fundo.png"), 0);
		
		jframe = new JFrame(title);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		
		jframe.setFocusable(true); //PARA NÃO ROUBAR A CARACTERISTICA DE PRESSIONAMENTO DA TECLA DO KEYLISTENER
		jframe.add(canvas);
		//jframe.add(background);
		jframe.pack();

		
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	
	public BufferStrategy getBufferStrategy() {
		return canvas.getBufferStrategy();
	}
	
	public void createBufferStrategy() {
		canvas.createBufferStrategy(3);
	}
	
	//CONTROLE DE TECLADO
	public void setKeyListener(KeyListener k1) {
		jframe.addKeyListener(k1); //JFRAME RECEBE OS EVENTOS DE CLIQUE
	}
	
	/*public int getHeight() {
		return height;
	}*/
}

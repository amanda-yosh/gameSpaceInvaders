package br.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display {

	private JFrame jframe;
	private Canvas canvas;
	private JLabel background;
	
	public Display(String title, int width, int height) {
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		background = new JLabel(new ImageIcon("src\\fundo.png"), 0);
		
		jframe = new JFrame(title);
		jframe.add(canvas);
		jframe.add(background);
		
		jframe.pack();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
}

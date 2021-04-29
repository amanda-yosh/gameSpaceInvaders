package br.display;

import javax.swing.JFrame;

public class Display {

	private JFrame jframe;
	
	public Display(String title) {
		jframe = new JFrame(title);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
}

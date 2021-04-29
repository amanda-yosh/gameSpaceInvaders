package br.display;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import br.Game;

public class Background {

	//Read the picture as a BufferedImage
	
	private BufferedImage img = null;
	
	public Background() {
	
		try {
			img = ImageIO.read(new File("src\\fundo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//Resize the BufferedImage
		Image dimg = img.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		
		//Create an ImageIcon
		ImageIcon imageIcon = new ImageIcon(dimg);
	}
}
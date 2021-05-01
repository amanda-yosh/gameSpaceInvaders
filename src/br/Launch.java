package br;

//CLASSE RESPONSÁVEL PELA EXECUÇÃO DO JOGO
public class Launch {

	public static void main(String[] args) {
		Game game = new Game();
		game.start(); //THREAD
	}
}

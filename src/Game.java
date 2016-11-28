import java.awt.BorderLayout;
import javax.swing.*;

/*
 * 
 * Classe Game
 * Deriva de JFrame, para configurar uma janela.
 * É o ponto de entrada do aplicativo.
 * Instancia os elementos principais:
 * 	- TelaGamePlay: responsável por organizar os principais elementos de jogo.
 *  - TimerGameplay: Timer(regressivo) que define o tempo das partidas.
 *   
 * */

public class Game extends JFrame{
	

	static final int WIDTH = 800;
	static final int HEIGHT = 576;
		
	//Panel do Timer
	TimerGameplay tgp = new TimerGameplay();
	TelaGamePlay tg1 = new TelaGamePlay(this);	
	
	public Game(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Collect the Garbage");
		this.setBounds(10,10,WIDTH,HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		
		//adicionando painel do Timer no topo
		this.add(tgp, BorderLayout.NORTH);
		
		this.add(tg1);
	}
	
	public static void main(String[] args) {
		Game g01 = new Game();
		g01.tg1.startup();
		g01.run();
		System.exit(0);
	}
	
	/*
	 * Main loop do aplicativo
	 * */
	public void run(){
		this.tg1.run();
	}
}

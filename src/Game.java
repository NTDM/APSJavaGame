import java.awt.BorderLayout;
import javax.swing.*;

public class Game extends JFrame{
	

	static final int WIDTH = 640;
	static final int HEIGHT = 576;
	  
	TelaGamePlay tg1 = new TelaGamePlay(this);	

	
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
		g01.run();
		System.exit(0);
	}
	
	public void run(){
		this.tg1.run();
	}
}

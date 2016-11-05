import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;


public class Game extends JFrame{
	
	Screen s1;
	TelaGamePlay tg1;
	
	public Game(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Collect the Garbage");
		this.setBounds(10,10,905,700);
		this.setResizable(false);
		this.setVisible(true);
		
		s1 = new Screen();
		tg1 = new TelaGamePlay();
		
		this.add(tg1);
		this.add(s1);
	}
	
	public static void main(String[] args) {
		Game g01 = new Game();
	}

}

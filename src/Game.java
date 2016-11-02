import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;


public class Game extends JFrame{
	
	Screen s1;
	
	public Game(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Collect the Garbage");
		this.setBackground(new Color(0, 77, 0));
		this.setBounds(10,10,905,700);
		this.setResizable(false);
		this.setVisible(true);
		
		s1 = new Screen();
		
		this.add(s1);
	}
	
	public static void main(String[] args) {
		Game g01 = new Game();
	}

}

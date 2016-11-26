import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class ScorePanel extends JPanel{
	
	static int score = 0;
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(622, 1, 95, 40);
	}
	
	public void ScoreText(Graphics g){
		super.paint(g);
	    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	    g.setColor(Color.BLACK);	    
	    g.drawString("Score: " + ScorePanel.getScore(), 625, 25);
	}
	
	public static int getScore(){
		return score;
	}
}



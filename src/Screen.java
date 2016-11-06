import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Screen extends JPanel{
	
	public void paint(Graphics g){
		//desenha a borda
		g.setColor(Color.RED);
		g.drawRect(24, 10, 800, 55);
	}
}



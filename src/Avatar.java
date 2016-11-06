import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Avatar extends JPanel{
	/*
 	x =  Posição do boneco em X
 	y =  Posição do boneco em y
 	vx = Deslocamento do boneco em x
 	vy = Deslocamento do boneco em y
	 */
	public int x = 0,y = 0, vx = 0, vy = 0;
	//image for render
	
	private TelaGamePlay tgp;
	
	public Avatar(TelaGamePlay t){
		this.tgp = t;
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 50, 30);		
	}

	public void update(){
		this.x += this.vx;
		this.y += this.vy;
	}
	
	
}

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Garbage extends JPanel{
	
	private int x, y,height = 10, width = 10;
	
	public Garbage(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.PINK);
		g.fillRect(x, y, height, width);
	}

	public void collision(Avatar av,Garbage lixo){
		if(this.x > av.cordX() && this.x < av.cordX() + 64){
			if(this.y > av.cordY() && this.y < av.cordY() + 64){
				this.setHeightZero();
				this.setWidthZero();
				lixo = null;
			}
		}
	}
	
	public void setHeightZero(){
		height = 0;
	}
	public void setWidthZero(){
		width = 0;
	}
}
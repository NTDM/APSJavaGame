import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Garbage extends JPanel{
	
	private int x, y,height = 10, width = 10;
	static int score = 0;
	
	public Garbage(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.PINK);
		g.fillRect(x, y, height, width);
	}
	
	//lixo especial
	public void paintSprecialGarbage(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 10, 10);
	}
	
	//fun�ao de colis�o
	public boolean collision(Avatar av,Garbage lixo){
		boolean colission = false;
		if(this.x > av.getX() && this.x < av.getX() + 64){
			if(this.y > av.getY() && this.y < av.getY() + 64){
				colission = true;
				this.anular();
				lixo = null;
			}
		}
		return colission;
	}
	
	/*
	  At� agora n�o consegui destruir o objeto, ent�o o trambique �:
	    - Zerar a altura;
	    - Zerar largura;
	    - Setando posi�oes negativas para x e y do objeto lixo, dessa forma ele n�o ocupar� mais espa�o;
	 */
	
	public void anular(){
		this.height = 0;
		this.width = 0;
		this.x = -1;
		this.y= -1;
	}
	
	public static int getScore(){
		return score;
	}
	public static void setScoreToZero(){
		score = 0;
	}
}
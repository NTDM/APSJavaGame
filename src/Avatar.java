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
	
	public void keyPressed(KeyEvent e){
		//Através dos eventos dos teclados movimentaremos o personagem
				int tecla = e.getKeyCode();
				
				//System.out.println("KEY PRESSED EVENT");
				
				if(tecla == KeyEvent.VK_LEFT){
					this.vx = -1;
					this.vy = 0;
				}
				
				if(tecla == KeyEvent.VK_RIGHT){
					this.vx = 1;
					this.vy = 0;
				}
				
				if(tecla == KeyEvent.VK_UP){
					this.vy = -1;
					this.vx = 0;
				}
				
				if(tecla == KeyEvent.VK_DOWN){
					this.vy = 1;
					this.vx = 0;
				}
	}
	
	public void keyReleased(KeyEvent e){
		//Fará com que o boneco pare de se mexermos quando largarmos a tecla
				this.vx = 0;
				this.vy = 0;
	}
	
}

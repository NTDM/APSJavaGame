import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import java.util.ArrayList;

public class Avatar extends JPanel{
	
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites;
	private Animator animator;
	
	//https://www.youtube.com/watch?v=sxBknKI2BfQ
	//https://www.youtube.com/watch?v=zRi0vzQbuqY
	
	//Image dbImage;
	//Graphics dbg;
	
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
		try{
			this.img = this.tgp.loader.loadImage("images/sprite_5.png");
		}catch(IOException ex){
			System.out.println("Erro carregando Sprite Avatar");
		}
		
		this.sprites = new ArrayList<BufferedImage>();
		
		SpriteSheet sprite = new SpriteSheet(this.img);
		this.sprites.add( sprite.grabSprite(64*0, 64*2, 64, 64) );
		this.sprites.add( sprite.grabSprite(64*1, 64*2, 64, 64) );
		this.sprites.add( sprite.grabSprite(64*2, 64*2, 64, 64) );
		this.sprites.add( sprite.grabSprite(64*3, 64*2, 64, 64) );
		
		this.animator = new Animator(this.sprites);
		this.animator.setSpeed(100);
		this.animator.play();
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		//g.setColor(Color.WHITE);
		//g.fillRect(x, y, 50, 30);
		
		//g.drawImage(this.img, x, y, 64, 64, null);
		
		g.drawImage(this.animator.sprite, x, y, 64, 64, null);
	}

	public void update(){
		this.x += this.vx;
		this.y += this.vy;
		this.animator.update(System.currentTimeMillis());
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

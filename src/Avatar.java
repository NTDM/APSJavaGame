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

/*
 * Classe Avatar
 * Representa o Personagem controlado pelo jogador.
 * 
 * 
 * */
public class Avatar extends JPanel{
	
	//Imagem base para retirar os quadros na animação do personagem
	private BufferedImage img;
	
	//Arraylist de imagens isoladas para as animações
	private ArrayList<BufferedImage> sprites;
	
	//Objeto que anima imagens alocadas no ArrayList sprites
	private Animator animator;
	
	//Estados so avatar
	private boolean upKey, downKey, leftKey, rightKey, idle = false;
	
	//Informações para organizar as animações
	private int spriteRow = 0;
	private int startSpriteAnim = 0;
	private int stopSpriteAnim = 0;
	
	/*
	 	x =  Posição do boneco em X
	 	y =  Posição do boneco em y
	 	vx = Deslocamento do boneco em x
	 	vy = Deslocamento do boneco em y
	*/
	private static int x = 0,y = 0, vx = 0, vy = 0;
	
	
	//Referência para o objeto "pai" do Avatar
	private TelaGamePlay tgp;
	
	//Construtor
	public Avatar(TelaGamePlay t){
		this.tgp = t;
		
		//Montando os Sprites
		// Carregando a imagem base
		try{
			this.img = this.tgp.loader.loadImage("images/sprite_5.png");
		}catch(IOException ex){
			System.out.println("Erro carregando Sprite Avatar");
		}
		
		this.sprites = new ArrayList<BufferedImage>();
		
		//Isolando os sprites
		SpriteSheet sprite = new SpriteSheet(this.img);
		for(int y=0 ; y<8 ; y++){
			for( int x=0 ; x<4 ; x++){
				this.sprites.add( sprite.grabSprite( 64*x, 64*y, 64, 64 ) );
			}
		}
		
		//Instanciando/configurando o Animator
		this.animator = new Animator(this.sprites);
		this.animator.setSpeed(75);
		this.animator.play();
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.drawImage(this.animator.sprite, x, y, 64, 64, null);
	}

	
	public void update(){
		//Atualiza o avatar
		this.updateMovement();
		
		//Atualiza o quadro da animação do Avatar
		this.animator.updateWithConstraint(System.currentTimeMillis(), this.startSpriteAnim , this.stopSpriteAnim);
	}
	
	//bloqueia a movimentação do Avatar
	//	Chamado quando o jogo termina 
	public void noMotion(){
		this.upKey = false;
		this.downKey = false;
		this.leftKey = false;
		this.rightKey = false;
		this.idle = false;
		
	}
	
	public void keyPressed(KeyEvent e){
		//Através dos eventos dos teclados alteramos os estados possíveis do Avatar
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_LEFT){
			this.leftKey = true;
		}
		if(tecla == KeyEvent.VK_RIGHT){
			this.rightKey = true;
		}
		if(tecla == KeyEvent.VK_UP){
			this.upKey = true;
		}
		if(tecla == KeyEvent.VK_DOWN){
			this.downKey = true;
		}	
	}
	
	public void keyReleased(KeyEvent e){
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_LEFT){
			this.leftKey = false;
		}
		if(tecla == KeyEvent.VK_RIGHT){
			this.rightKey = false;
		}
		if(tecla == KeyEvent.VK_UP){
			this.upKey = false;
		}
		if(tecla == KeyEvent.VK_DOWN){
			this.downKey = false;
		}
	}
	
	private void updateMovement(){
		//A cada estado do Avatar mudamos:
		// 1 - os valores do deslocamento
		if(this.upKey){
			this.vy = -1;
		}
		else if(this.downKey){
			this.vy = 1;
		}
		else{
			this.vy = 0;
		}
		
		if(this.leftKey){
			this.vx = -1;
		}
		else if(this.rightKey){
			this.vx = 1;
		}
		else{
			this.vx = 0;
		}
		
		// 2 - A "linha" da sequencia de imagens que faz a animação, de acordo com o a direçnao do deslocamento do Avatar
		if( this.upKey && this.leftKey ){
			this.spriteRow = 6;
		}
		else if( this.upKey && this.rightKey ){
			this.spriteRow = 7;
		}
		else if( this.downKey && this.leftKey ){
			this.spriteRow = 5;
		}
		else if( this.downKey && this.rightKey ){
			this.spriteRow = 4;
		}
		else if(this.upKey)		this.spriteRow = 3; 
		else if(this.downKey)	this.spriteRow = 0;
		else if(this.leftKey)	this.spriteRow = 1;
		else if(this.rightKey)	this.spriteRow = 2;
		
		// 3 - Atualização das informações para o Animator
		if( !this.upKey   && 
			!this.downKey && 
			!this.leftKey && 
			!this.rightKey ){
			this.startSpriteAnim = this.spriteRow*4;
			this.stopSpriteAnim = this.spriteRow*4;
			
			this.animator.setStart(this.spriteRow*4);
			this.animator.setStop(this.spriteRow*4);
			}
		else{
			this.startSpriteAnim = this.spriteRow*4;
			this.stopSpriteAnim = this.spriteRow*4+3;
			
			this.animator.setStart(this.spriteRow*4);
			this.animator.setStop(this.spriteRow*4+3);
		}
		
		// 4 - Atualização da posição do Avatar 
		this.x += this.vx;
		this.y += this.vy;
		
		// 5 - Limites de deslocamento do Avatar 
		if( this.x < 0) this.x = 0;
		else if( this.x+64 > TelaGamePlay.WIDTH ) this.x = TelaGamePlay.WIDTH-64;
		
		if(this.y < 0)this.y = 0;
		else if(this.y+64 > TelaGamePlay.HEIGHT) this.y = TelaGamePlay.HEIGHT-64;
		
	}
	
	//coordenadas x e y do avatar
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}

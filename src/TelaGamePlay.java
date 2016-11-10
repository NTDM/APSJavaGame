import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;

import javax.swing.*;

public class TelaGamePlay extends GameLoop implements ActionListener, KeyListener{
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 576;
	
	private Game game;
	public Loader loader;
	Avatar av;
	
	ParqueMapa mapa;
	
	public TelaGamePlay(Game game){
		this.game = game;
		this.loader = new Loader();
		
		//Posicionamento e design do panel da Gameplay
		this.setBounds( 0,0, 640,576);
		this.setBackground(Color.BLACK);
		
		addKeyListener(this);
		
		//Ajustando o foco do boneco
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		//Avatar
		this.av = new Avatar(this);
		this.add(this.av);
		
		//Mapa
		
		int[][] m = {
				{0,1,2,0,1,2,0,1,2,0},
				{1,0,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0},
				{0,1,2,0,1,2,0,1,2,0}
		};
		
		this.mapa = new ParqueMapa(TelaGamePlay.WIDTH, TelaGamePlay.HEIGHT, 64, m );
		this.add(this.mapa);
	}
	
	//desenha os objetos de jogo
	public void paint(Graphics g){
		super.paint(g);
		
		//Mapa
		this.mapa.paint(g);
		
		//Avatar
		this.av.paint(g);	
		
	}
	
	//configura inicio do jogo
	public void startup(){}
	
	//encerra o jogo 
    public void shutdown(){}
    
    //atualiza os objetos de jogo
    public  void update(double delta){
    	this.av.update();
    }
    
    //atualiza renderização
    public void draw(){
    	this.repaint();
    }
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*/limites do campo e coordenadas
		System.out.println("ACTION EVENT");
		
		if(this.av.x<0){
			this.av.vx = 0;
			this.av.x = 0;
		}
		
		if(this.av.x> 800){
			this.av.vx = 0;
			this.av.x = 800;
		}
		
		if(this.av.y<0){
			this.av.vy = 0;
			this.av.y = 0;
		}
		
		if(this.av.y> 570){
			this.av.vy = 0;
			this.av.y = 570;
		}
		this.av.x = this.av.x + this.av.vx;
		this.av.y = this.av.y + this.av.vy;
		
		//repaint();//*/
	}//*/

	@Override
	public void keyPressed(KeyEvent e) {
		this.av.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.av.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	
}

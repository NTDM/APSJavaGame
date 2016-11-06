import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TelaGamePlay extends GameLoop implements ActionListener, KeyListener{
	
	//timer para controlarmos o delay da movimentaçao do personagem
	//Timer tm = new Timer(5,this);
	private Game game;
	Avatar av;
	
	public TelaGamePlay(Game game){
		this.game = game;
		//Posicionamento e design do panel da Gameplay
		this.setBounds( 25,75, 640,480);
		this.setBackground(Color.BLACK);
		
		//Inicio dos movimentos
		//tm.start();
		addKeyListener(this);
		//Ajustando o foco do boneco
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		this.av = new Avatar(this);
		
		this.add(this.av);
	}
	
	//desenha os objetos de jogo
	public void paint(Graphics g){
		super.paint(g);
		
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
		//Através dos eventos dos teclados movimentaremos o personagem
		int tecla = e.getKeyCode();
		
		//System.out.println("KEY PRESSED EVENT");
		
		if(tecla == KeyEvent.VK_LEFT){
			this.av.vx = -1;
			this.av.vy = 0;
		}
		
		if(tecla == KeyEvent.VK_RIGHT){
			this.av.vx = 1;
			this.av.vy = 0;
		}
		
		if(tecla == KeyEvent.VK_UP){
			this.av.vy = -1;
			this.av.vx = 0;
		}
		
		if(tecla == KeyEvent.VK_DOWN){
			this.av.vy = 1;
			this.av.vx = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Fará com que o boneco pare de se mexermos quando largarmos a tecla
		this.av.vx = 0;
		this.av.vy = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	
}

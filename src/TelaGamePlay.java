import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TelaGamePlay extends JPanel implements ActionListener, KeyListener{
	
	//timer para controlarmos o delay da movimentaçao do personagem
	Timer tm = new Timer(5,this);
	
	/*
	 	x =  Posição do boneco em X
	 	y =  Posição do boneco em y
	 	vx = Deslocamento do boneco em x
	 	vy = Deslocamento do boneco em y
	*/
	int x = 0,y = 0, vx = 0, vy = 0;
	
	public TelaGamePlay(){
		//Posicionamento e design do panel da Gameplay
		this.setBounds(25, 75,851, 600);
		this.setBackground(Color.BLACK);
		
		//Inicio dos movimentos
		tm.start();
		addKeyListener(this);
		//Ajustando o foco do boneco
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 50, 30);		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//limites do campo e coordenadas
		
		if(x<0){
			vx = 0;
			x = 0;
		}
		
		if(x> 800){
			vx = 0;
			x = 800;
		}
		
		if(y<0){
			vy = 0;
			y = 0;
		}
		
		if(y> 570){
			vy = 0;
			y = 570;
		}
		x = x + vx;
		y = y + vy;
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Através dos eventos dos teclados movimentaremos o personagem
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_LEFT){
			vx = -1;
			vy = 0;
		}
		
		if(tecla == KeyEvent.VK_RIGHT){
			vx = 1;
			vy = 0;
		}
		
		if(tecla == KeyEvent.VK_UP){
			vy = -1;
			vx = 0;
		}
		
		if(tecla == KeyEvent.VK_DOWN){
			vy = 1;
			vx = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Fará com que o boneco pare de se mexermos quando largarmos a tecla
		vx = 0;
		vy = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}

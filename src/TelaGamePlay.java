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
	public static final int HEIGHT = 480;
	
	private Game game;
	public Loader loader;
	Avatar av;
	
	//Array de lixos
	Garbage[] lixo = new Garbage[10];
	
	//lixo especial
	Garbage lixoEspecial;
	
	//painel do Score
	ScorePanel sp;
	
	//Mapa do Parque
	ParqueMapa mapa;
	
	public TelaGamePlay(Game game){
		this.game = game;
		this.loader = new Loader();
	
		//Posicionamento e design do panel da Gameplay
		this.setBounds( 0,0, 640,512);
		this.setBackground(Color.BLACK);
		
		addKeyListener(this);
		
		//Ajustando o foco do boneco
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		//Avatar
		this.av = new Avatar(this);
		this.add(this.av);
		
		//Mapa
		int m[] = { 
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ,
				0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 
		};
		
		//Criação dos lixos
		lixo[0] = new Garbage(220,5);
		lixo[1] = new Garbage(89,68);
		lixo[2] = new Garbage(125,100);
		lixo[3] = new Garbage(300,10);
		lixo[4] = new Garbage(150,80);
		lixo[5] = new Garbage(20,110);
		lixo[6] = new Garbage(40,200);
		lixo[7] = new Garbage(350,200);
		lixo[8] = new Garbage(200,70);
		lixo[9] = new Garbage(70,300);
		
		//adicionando lixos na Tela
		for(int i=0;i<10;i++){
			this.add(lixo[i]);
		}
		
		//adicionando lixo especial na tela(posição fixa)
		this.lixoEspecial = new Garbage(300, 300);
		this.add(this.lixoEspecial);
		
		//adicionando painel de score
		this.sp = new ScorePanel();
		this.add(this.sp);
		
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
	
		//painel de Score
		this.sp.paint(g);
		this.sp.ScoreText(g);

		//lixo
		for(int i=0;i<10;i++){
			this.lixo[i].paint(g);;
		}
		
		//A partir de 15 segundos o lixo especial irá aparecer
		if(TimerGameplay.tempo <= 15){
    		this.lixoEspecial.paintSprecialGarbage(g);
    	}
	}
	
	//configura inicio do jogo
	public void startup(){}
	
	//encerra o jogo 
    public void shutdown(){}
    
    //atualiza os objetos de jogo
    public  void update(double delta){
    	this.av.update();
    	
    	//checará a cada update se haverá colisão
    	for(int i=0;i<10;i++){
    		//se houver colisão entre Avatar e os lixos normais, serão acrescidos 10 pontos ao player
			if(this.lixo[i].collision(av, lixo[i])){
				Garbage.score += 10;
			}
		}
    	
    	//Checa se todos os lixos Foram coletados
    	if(Garbage.getScore() == 100){
    		JOptionPane.showMessageDialog(null, "Fase 1 concluída!!!");
    		Garbage.setScoreToZero();
    	}
    	
    	//se houver colisão entre Avatar e o lixo especial, serão acrescidos 10 segundos a mais para o player
    	if(lixoEspecial.collision(av, lixoEspecial)){
    		TimerGameplay.tempo += 10; 
    	}
    }
    
    //atualiza renderizaÃ§Ã£o
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

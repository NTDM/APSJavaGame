import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class TimerGameplay extends JPanel{
	
	static Timer timer;
	static JLabel lbltimer;
	//tempo do timer
	static int tempo = 30;
	
	public TimerGameplay(){
		this.setSize(800,100);
		lbltimer = new JLabel("Tempo: 30");
		this.add(lbltimer);
		initTimer();
	}
	
	//Timer de 30 segundos
	public static void initTimer(){
		timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	//se o player coletar todas os lixos, o tempo para
	        	if(Garbage.getScore() == 100){
	        		timer.cancel();
	        	}
	        	//se o Tempo se esgotar, é game over!!!
	        	else if (tempo == 0){
	    	        timer.cancel();
	            	JOptionPane.showMessageDialog(null, "Seu Tempo Acabou!!!\nFinal Score: " + Garbage.getScore(), "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
            		JOptionPane.showMessageDialog(null, "Fechando o Jogo...");
            		System.exit(0);
	            }
	        	//Senão, vai contando
	        	else{
	            	lbltimer.setText("Tempo: "+ --tempo);
	            }
	
	        }
		}, 1000, 1000);
	}
}

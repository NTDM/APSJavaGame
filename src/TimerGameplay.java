import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class TimerGameplay extends JPanel{
	
	static Timer timer;
	static JLabel lbltimer;
	
	//tempo do timer
	static int tempo = 30;
	
	public TimerGameplay(){
		this.setSize(800,110);
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
	        	if(ScorePanel.getScore() == 100){
	        		timer.cancel();
	        	}
	        	//se o Tempo se esgotar, é game over!!!
	        	else if (tempo == 0){
	    	        timer.cancel();
            		Avatar.noMotion();
            		//System.exit(0);
	            }
	        	//Senão, vai contando
	        	else{
	            	lbltimer.setText("Tempo: "+ --tempo);
	            }
	        }
		}, 1000, 1000);
	}
}

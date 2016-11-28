import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerView extends JPanel{

	private JLabel lbltimer;
	
	public TimerView(){
		this.setSize(800,110);
		
		lbltimer = new JLabel("Tempo: 30");
		this.add(lbltimer);
	}
	
	public void setViewValue(String value){
		this.lbltimer.setText(value);
	}
	
}

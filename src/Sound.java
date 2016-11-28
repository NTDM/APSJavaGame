

import java.applet.Applet;
import java.applet.AudioClip;

/*
 * Sound
 * 
 * Cria pequenos terchos de som, para efeitos, e trilha sonora.
 * 
 * */

public class Sound {

	private AudioClip clip;
	
	
	public Sound(String filename){
		//carrega o arquivo de som
		try{
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play(){
		//executa o som
		try{
			new Thread(){
				public void run(){
					clip.play();
				}
			}.start();
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void loop(){
		//executa o som em loop
		this.clip.loop();
	}
	
}


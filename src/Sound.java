

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	private AudioClip clip;
	
	
	public Sound(String filename){
		try{
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play(){
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
		this.clip.loop();
	}
	
}
//*/

/*
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	Clip clip;
	
	public Sound(String filename){
		AudioInputStream inputStream;
		try {
			inputStream = AudioSystem.getAudioInputStream(new File( Sound.class.getResource(filename) ));
			this.clip = AudioSystem.getClip();
			this.clip.open(inputStream);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
	}
	
	public void play(){
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
}
//*/

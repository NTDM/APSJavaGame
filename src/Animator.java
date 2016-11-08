import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Animator {
	private ArrayList<BufferedImage> frames;
	public BufferedImage sprite;
	
	private volatile boolean running = false;
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	
	public Animator( ArrayList<BufferedImage> frames ){
		this.frames = frames;
	}
	
	public void setSpeed(long speed){ this.speed = speed; }
	
	public void update(long time){
		if(this.running){
			if(time - this.previousTime >= this.speed){
				this.currentFrame++;
				try{
					this.sprite = this.frames.get(this.currentFrame);
				}catch(IndexOutOfBoundsException e){
					 this.currentFrame = 0;
					 this.sprite = this.frames.get(this.currentFrame);
				}
				this.previousTime = time;
			}
		}
	}
	
	public void updateWithConstraint(long time, int start, int end){
		if(this.running){
			if(time - this.previousTime >= this.speed){
				this.currentFrame++;
				if(this.currentFrame > end) this.currentFrame = start;
				try{
					this.sprite = this.frames.get(this.currentFrame);
				}catch(IndexOutOfBoundsException e){
					this.currentFrame = start;
					this.sprite = this.frames.get(this.currentFrame);
				}
				this.previousTime = time;
			}
		}
	}
	
	public void play(){
		this.running  = true;
		this.currentFrame = 0;
		this.previousTime = 0;
		this.frameAtPause = 0; 
	}
	
	public void pause(){
		this.frameAtPause = this.currentFrame;
		this.running = false;
	}
	
	public void stop(){
		this.running  = false;
		this.currentFrame = 0;
		this.previousTime = 0;
		this.frameAtPause = 0; 
	}
	public void resume(){
		this.currentFrame = this.frameAtPause;
		this.running = true;
	}
	
}

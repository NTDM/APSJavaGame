import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Loader {
	public static HashMap<String, BufferedImage> images;
	//public
	
	/*
	 * AUDIOS:
	 * CM139_Loop06
	 * 
	 * */
	
	Loader(){
		if( Loader.images == null  ){
			Loader.images = new HashMap<String, BufferedImage>();
		}
	}
	
	public BufferedImage loadImage(String relativePath) throws IOException {
		
		if( Loader.images.containsKey(relativePath) ){
			return Loader.images.get(relativePath);
		}
		
		URL url = this.getClass().getResource(relativePath);
		BufferedImage img = ImageIO.read(url);
		
		Loader.images.put(relativePath, img);
		
		return img;
	}
	
}

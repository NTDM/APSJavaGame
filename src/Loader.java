import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Loader {
	
	public BufferedImage loadImage(String relativePath) throws IOException {
		URL url = this.getClass().getResource(relativePath);
		BufferedImage img = ImageIO.read(url);
		
		return img;
	}
	
}



import java.awt.image.BufferedImage;

/*
  Salva um sprite em um BufferedImage
*/

public class SpriteSheet {
	
	public BufferedImage spriteSheet;
	
	public SpriteSheet( BufferedImage bi){
		this.spriteSheet = bi;
		
	}
	
	public BufferedImage grabSprite(int x, int y, int width, int height){
		BufferedImage sprite = this.spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
}

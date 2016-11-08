import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MapCell extends JPanel{
	
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites;
	
	private int side;
	private int x, y;
	private int category;
	
	MapCell(int x, int y, int l, int cat){
		this.x = x;
		this.y = y;
		this.side = l;
		this.category = cat;
		//this.sprites = new ArrayList<BufferedImage>();
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillRect(this.x, this.y, this.side, this.side);
		//g.drawImage(this.animator.sprite, x, y, 64, 64, null);
	}
	
}

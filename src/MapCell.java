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
	
	private Color cor;
	
	MapCell(int x, int y, int l, int cat){
		this.x = x;
		this.y = y;
		this.side = l;
		this.category = cat;
		
		if(cat == 0) this.cor = Color.RED;
		else if(cat == 1) this.cor = Color.GREEN;
		else if(cat == 2) this.cor = Color.BLUE;
		else this.cor = Color.BLACK;
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.setColor(this.cor);
		g.fillRect(this.x, this.y, this.side, this.side);
		//g.drawImage(this.animator.sprite, x, y, 64, 64, null);
	}
	
}

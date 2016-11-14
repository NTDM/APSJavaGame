import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;


public class MapCell extends JPanel{
	
	private BufferedImage sprite;
	
	private int side;
	private int x, y;
	private int category;
	
	private Color cor;
	
	/*	CELLS CODE
	 * 0 - TUDO AREIA
	 * 10 - TUDO GRAMA FRACA
	 * 20 - TUDO GRAMA FORTE
	 * 
	 * */
	
	MapCell(int x, int y, int l, int cat){
		this.x = x;
		this.y = y;
		this.side = l;
		this.category = cat;
		
		//if(cat == 0) this.cor = Color.RED;
		//else if(cat == 1) this.cor = Color.GREEN;
		//else if(cat == 2) this.cor = Color.BLUE;
		//else this.cor = Color.BLACK;
		
		int[] sprite_coord = this.getSpritePos(cat);
		
		Loader loader = new Loader();
		BufferedImage temp = null;
		
		try{
			temp = loader.loadImage("images/maptiles.png");
		}catch(IOException ex){
			System.out.println("Erro carregando Sprite Avatar");
		}
		
		SpriteSheet ss = new SpriteSheet(temp);
		this.sprite = ss.grabSprite( this.side*sprite_coord[0], this.side*sprite_coord[1], this.side, this.side );
		temp = null;
	}
	
	private int[] getSpritePos(int pos){
		int[] c = new int[2];
		
		//System.out.println("Get Sprite Coord: "+pos);
		
		switch(pos){
		case 0:
			c[0] = 22;
			c[1] = 1;
			break;
			case 1:
				c[0] = 22;
				c[1] = 0;
				break;
			case 2:
				c[0] = 23;
				c[1] = 0;
				break;
			case 3:
				c[0] = 23;
				c[1] = 1;
				break;
			case 4:
				c[0] = 23;
				c[1] = 2;
				break;
			case 5:
				c[0] = 22;
				c[1] = 2;
				break;
			case 6:
				c[0] = 21;
				c[1] = 2;
				break;
			case 7:
				c[0] = 21;
				c[1] = 1;
				break;
			case 8:
				c[0] = 21;
				c[1] = 0;
				break;
				
		case 10:
			c[0] = 21;
			c[1] = 2;
			break;
			case 11:
				c[0] = 22;
				c[1] = 0;
				break;
			case 12:
				c[0] = 23;
				c[1] = 0;
				break;
			case 13:
				c[0] = 23;
				c[1] = 1;
				break;
			case 14:
				c[0] = 23;
				c[1] = 2;
				break;
			case 15:
				c[0] = 22;
				c[1] = 2;
				break;
			case 16:
				c[0] = 27;
				c[1] = 0;
				break;
			case 17:
				c[0] = 21;
				c[1] = 1;
				break;
			case 18:
				c[0] = 27;
				c[1] = 1;
				break;
			
		case 20:
			c[0] = 21;
			c[1] = 4;
			break;
			case 21:
				c[0] = 21;
				c[1] = 3;
				break;
			case 22:
				c[0] = 22;
				c[1] = 3;
				break;
			case 23:
				c[0] = 22;
				c[1] = 4;
				break;
			case 24:
				c[0] = 22;
				c[1] = 5;
				break;
			case 25:
				c[0] = 21;
				c[1] = 4;
				break;
			case 26:
				c[0] = 20;
				c[1] = 5;
				break;
			case 27:
				c[0] = 20;
				c[1] = 4;
				break;
			case 28:
				c[0] = 20;
				c[1] = 3;
				break;
		}
		
		return c;
	}
	
	public void paint(Graphics g){
		//desenhando o boneco
		super.paint(g);
		g.setColor(this.cor);
		//g.fillRect(this.x, this.y, this.side, this.side);
		g.drawImage(this.sprite, x, y, this.side, this.side, null);
	}
	
}

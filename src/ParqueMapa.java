import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ParqueMapa extends JPanel{
	
	private int width, height;
	private int cellSize;
	private int[] map;
	private ArrayList<MapCell> cells;
	
	ParqueMapa(int w, int h, int cellSize, int[] mapa){
		
		this.width = w;
		this.height = h;
		this.cellSize = cellSize;
		this.map = mapa;
		
		this.cells = new ArrayList<MapCell>();
		
		this.setupMap();
		
	}
	
	private void setupMap(){
		int qtd_width = this.width / this.cellSize;
		//int qtd_height = this.height / this.cellSize;
		int totalCells = this.map.length;
		int x = 0;
		int y = 0;
		
		for(int i=0 ; i<totalCells ; i++){
			this.cells.add( new MapCell( x*this.cellSize, y*this.cellSize, this.cellSize, 0) );
			
			if( x >= qtd_width){
				x = 0;
				y++;
			}
			else{ x++; }
		}
		
	}
	
	public void paint(Graphics g){
		//desenhanda mapa
		super.paint(g);
		//g.drawImage(this.animator.sprite, x, y, 64, 64, null);
		for(int i=0 ; i<this.cells.size() ; i++){
			MapCell c = this.cells.get( i );
			c.paint(g);
		}
	}
	
}

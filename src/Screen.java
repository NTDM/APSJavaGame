import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Screen extends JPanel{
	
	private ImageIcon titulo;
	
	public Screen(){
		
	}
	
	public void paint(Graphics g){
		//desenha a borda
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		
		//desenha o titulo da imagem
		titulo = new ImageIcon("alguma-imagem-bolada-pra-quem-manja-de-photoshop-kkkkk.jpg");
		titulo.paintIcon(this, g, 25, 11);
		
		//desenha a borda da tela de gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 600);
		
		//desenha a tela de gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 851, 600);
		
	}
}

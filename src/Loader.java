import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/*
 * Loader
 * 
 * Classe auxiliar para carregamento de imagens
 * 
 * Os objetos que compoem o jogo, usam de poucas imagens tiles.
 * Porém se cada objeto carregasse a mesma imagem tantas vezes, o desempenho se torna crítico.
 * Com o objetivo de otimizar o uso dessas imagens, essa classe foi feita.
 * 
 * A propriedade HashMap, aloca as imagens apenas uma vez cada uma, e apenas quando solicitadas.
 * E apartir dessas imagesn, os sprites são criados.
 * 
 * */

public class Loader {
	
	// Armazena as imagens
	public static HashMap<String, BufferedImage> images;
	
	
	Loader(){
		if( Loader.images == null  ){
			Loader.images = new HashMap<String, BufferedImage>();
		}
	}
	
	public BufferedImage loadImage(String relativePath) throws IOException {
		// caso a imagem solicitada já tenha sido carregada anteriormente,
		// essa imagem é repassada ao solicitante.
		if( Loader.images.containsKey(relativePath) ){
			return Loader.images.get(relativePath);
		}
		
		// Carrega/retorna a imagem solicitada
		URL url = this.getClass().getResource(relativePath);
		BufferedImage img = ImageIO.read(url);
		
		Loader.images.put(relativePath, img);
		
		return img;
	}
	
}

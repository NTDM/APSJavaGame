import java.awt.BorderLayout;
import javax.swing.*;

public abstract class GameLoop extends JPanel{
    
	private boolean runFlag = false;
    public double fps;
    public double lastFpsTime;
    
    public GameLoop(){
    	super();
    }
    
    public void run()
    {
        runFlag = true;
        
        // função para configurar inicio do jogo
        startup();
        
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        
        while(runFlag){
        	long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // Atualiza contagem de FPS
            lastFpsTime += updateLength;
            fps++;
            
            // Atualiza contagem de FPS ao término de 1 segundo
            if (lastFpsTime >= 1000000000)
            {
               lastFpsTime = 0;
               fps = 0;
            }
            
            // atualiza os dados dos objetos
            update(delta);
            
            // desenha os objetos
            draw();
            
            // pausa a thread
            try{
            	Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }catch(Exception e) {} 
        }
        shutdown();  
    }
 
    public void stop()
    {
        runFlag = false;
    }
 
    public abstract void startup();
    public abstract void shutdown();
    public abstract void update(double delta);
    public abstract void draw();
}
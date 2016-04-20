import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * this class is for testing
 ******************************************* 
 * NOTES 
 * tested keyboard
 * This test the controls
 ******************************************* 
 * @author josuerojas
 * 
 */
public class Test extends JFrame implements Runnable {
	
	BufferedImage backBuffer;
	boolean pause = false;
	int x =100;
	int y = 100;
	float sizeX;
	float sizeY;
	int s = 1;
	
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double fullW = screenSize.getWidth();
	double fullH = screenSize.getHeight();
	
	//width and height
	int w = 500, h = 500;
	
	//controllers
	PS3Control k; //addKeyListener() in init() w/ a cast if its a keyboard
	
	
	public static void main(String[] args) {
		Test game = new Test(); 
		game.init();
        game.run(); 

        System.exit(0); 
	}

	public void draw() {
		
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics(); 

		bbg.setColor(Color.WHITE); 
		bbg.fillRect(0, 0, w, h); 
		
		bbg.setColor(Color.BLACK); 
		bbg.drawOval(x, y, (int)(sizeX*100) + 200, (int)(sizeY*100) + 120); 
		
		if(k.pressAct1()){
			bbg.drawString("Square is pressed", 100, 120);
			s = 5;
		}
		else{
			bbg.drawString("Sqaure is not pressed", 100, 120);
			s = 1;
		}
		if(k.pressAct2()){
			bbg.drawString("Triangle is pressed", 100, 140);
		}
		else{
			bbg.drawString("Triangle is not pressed", 100, 140);
		}
		if(k.pressAct3()){
			bbg.drawString("Circle is pressed", 100, 160);
		}
		else{
			bbg.drawString("Circle is not pressed", 100, 160);
		}
		
		if(k.pressAct4()){
			bbg.drawString("X is pressed", 100, 180);
		}
		else{
			bbg.drawString("X is not pressed", 100, 180);
		}
		
		if(k.pressSelect()){
			bbg.drawString("Select is pressed", 100, 200);
		}
		else{
			bbg.drawString("Select is not pressed", 100, 200);
		}
		if(k.pressStart()){
			bbg.drawString("Start is pressed", 100, 220);
		}
		else{
			bbg.drawString("Start is not pressed", 100, 220);
		}
		
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}

	public void update() {
		if(k.pressLeft()){
			x = x -s;
		}
		else if (k.pressRight()){
			x = x + s;
		}
		if(k.pressUp()){
			y--;
		}
		else if (k.pressDown()){
			y++;
		}
		sizeX = k.getLX();
		sizeY = k.getLY();
	}

	/**
	 * this method initializes everything
	 */
	public void init() {
		k = new PS3Control();
		setTitle("Game"); 
		setSize(w, h); 
	    setFocusable(true);
	    requestFocusInWindow();
	    setResizable(true);
	    //addKeyListener((KeyListener) k);
     
	    //buffering
	    backBuffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    setVisible(true); 
	
	}

	/**
	 * this is sort of like the main() but in a loop
	 */
	public void run() {
		
		while (true) {
			
			update();
			draw();
			
			try {
				Thread.sleep(16);
			} catch (Exception e) {
			}
		}

	}


}

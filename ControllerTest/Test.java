import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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
 * Havent tested ps3 remote
 * This test the controls
 ******************************************* 
 * @author josuerojas
 * 
 */
public class Test extends JFrame implements Runnable {
	
	BufferedImage backBuffer;
	boolean pause = false;
	int x =100;
	
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double fullW = screenSize.getWidth();
	double fullH = screenSize.getHeight();
	
	//width and height
	int w = 500, h = 500;
	
	static //controllers
	KeyboardControl k; //addKeyListener() in init()
	
	
	public static void main(String[] args) {
		Test game = new Test(); 
		game.init();
		game.addKeyListener(k);
        game.run(); 

        System.exit(0); 
	}

	public void draw() {
		
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics(); 

		bbg.setColor(Color.WHITE); 
		bbg.fillRect(0, 0, w, h); 
		
		bbg.setColor(Color.BLACK); 
		bbg.drawOval(x, 100, 200, 120); 
		
		if(k.pressAct1()){
			//System.out.println("P is pressed");
			bbg.drawString("A is pressed", 100, 100);
		}
		else{
			bbg.drawString("A is not pressed", 100, 100);
		}
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}

	public void update() {
		if(k.pressLeft()){
			x--;
		}
		else if (k.pressRight()){
			x++;
		}
	}

	/**
	 * this method initializes everything
	 */
	public void init() {
		k = new KeyboardControl();
		setTitle("Game"); 
		setSize(w, h); 
	    setFocusable(true);
	    requestFocusInWindow();
	    setResizable(true);
	    addKeyListener(k);
     
	    //buffering
	    backBuffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    setVisible(true); 
	
	}

	/**
	 * this is sort of like the main() but in a loop
	 */
	@Override
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * this class is the main game (Revenge)
 ******************************************* 
 * @author josuerojas
 * 
 */
public class Revenge extends JFrame implements Runnable {
	
	BufferedImage backBuffer;
	boolean pause = false;
	StartScreen startScreen;
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int fullW = (int) screenSize.getWidth();
	int fullH = (int) screenSize.getHeight();

	KeyboardControl k = new KeyboardControl();
	public static void main(String[] args) {
		Revenge game = new Revenge(); 
		game.init();
        game.run(); 

        System.exit(0); 
	}

	public void draw() {
		
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics(); 
		bbg.setColor(Color.WHITE); 
		bbg.fillRect(0, 0, fullW, fullH);
		if(!k.pressStart()){
			startScreen.draw(bbg); 
		}
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}
	
	public void update() {
	}

	/**
	 * this method initializes everything
	 */
	public void init() {
		setTitle("Driver's Revenge"); 
		setSize(fullW, fullH); 
	    setFocusable(true);
	    requestFocusInWindow();
	    setResizable(true);
	    addKeyListener(k);
	    //buffering
	    backBuffer = new BufferedImage(fullW, fullH, BufferedImage.TYPE_INT_RGB); 
	    //initialize screens
	    startScreen = new StartScreen(fullW,fullH);
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

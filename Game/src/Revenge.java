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
	//the following booleans are for which screen to show
	boolean pause = false;
	boolean start = true;
	boolean select = false;
	StartScreen startScreen;
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int fullW = (int) screenSize.getWidth();
	int fullH = (int) screenSize.getHeight();

	KeyboardControl k = new KeyboardControl();
	int time;
	int delay; //delay for button presses
	
	
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
		bbg.setColor(Color.black);
		bbg.drawString("Time: " + time, 20, 40);
		if(start){
			if(select){
				//selectScreen.draw() should go here.
				//this screen should be where the credits are given. or the info
				bbg.drawString("Press select", 20, 60);
			}
			else{
				bbg.drawString("Press not select", 20, 60);
				startScreen.draw(bbg); 
			}
		}
		else{
			//start game here
		}
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}
	
	public void update() {
		time++;
		delay++;
		//change the screen 
		if(k.pressStart()){
			start = false;
		}
		//if it is the start screen and press select when the delay is greater than 30
		if(start && k.pressSelect() && delay > 30){
			select = !select;
			delay = 0;
		}
	}

	/**
	 * this method initializes everything
	 */
	public void init() {
		setTitle("Driver's Revenge"); //title
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
	    //time is a clock for keeping track of delays etc
	    time = 0;
	    delay = 0;
	
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JCheckBoxMenuItem; //check box menu
import javax.swing.JFrame; //window
import javax.swing.JMenu; //menu
import javax.swing.JMenuBar; //menu bar
import javax.swing.JMenuItem; //menu item
import javax.swing.JRadioButtonMenuItem; //radio menu button
import javax.swing.JOptionPane;

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
	boolean playerSelect = false;
	StartScreen startScreen;
	CreditScreen creditScreen;
	Background background;
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//int fullW = (int) screenSize.getWidth();
	//int fullH = (int) screenSize.getHeight();
	
	//the images are set up for this dimension
	int fullW = 1024;
	int fullH = 640;
	
	//image layers
	ImageLayer b1;
	ImageLayer b2;
	ImageLayer b3;
	

	KeyboardControl k = new KeyboardControl();
	int time;
	int delay; //delay for button presses
	
	String player;

	
	
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
		if(start){
			background.draw(bbg, 0, 0);
			if(select){ //this is the select screen (setting/credit/info screen)
				creditScreen.draw(bbg); //display credits
					if(playerSelect){ //this should be handled somewhere else
						player = JOptionPane.showInputDialog("Current Player: " + player);
						if(player == null || player.equals("")){ //avoid empty box
							player = "Player1";
						}
						playerSelect = false;
						k.Start = false; //there is a bug here where it gets stuck in true (will fix later for now this is quick fix)
					}
			}
			else{
				bbg.drawString("Press not select", 20, 60);
				startScreen.draw(bbg); 
			}
		}
		else{
			b3.draw(bbg);
			b2.draw(bbg);
			b1.draw(bbg);
		}
		bbg.drawString("Time: " + time, 20, 40);
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}
	
	/**
	 * this method handles all the update stuff
	 */
	public void update() {
		time++;
		delay++;
		//change the screen 
		if(select && k.pressStart() && delay > 30){
			playerSelect = true;
			delay = 0;
		}
		else if(k.pressStart() && delay > 30){
			start = false;
			delay = 0;
		}
		//if it is the start screen and press select when the delay is greater than 30
		if(start && k.pressSelect() && delay > 30){
			select = !select;
			delay = 0;
		}
		//if you are in the game controls
		if(start == false){
			if(k.pressLeft()){
				Camera.moveBy(-5, 0);
			}
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
	    creditScreen = new CreditScreen(fullW,fullH);
	    background = new Background(fullW,fullH);
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    setVisible(true); 
	    Camera.setLocation(200, 0);
	    //time is a clock for keeping track of delays etc
	    time = 0;
	    delay = 0;
	    player = "Player1"; //starts with default player 'Player1'
	
	    b1 = new ImageLayer("trees.gif");
	    b2 = new ImageLayer("houses.gif", 2);
	    b3 = new ImageLayer("mountains.gif", 8);
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

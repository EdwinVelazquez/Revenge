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
	boolean credit = false;
	boolean playerSelect = false;
	
	//screens
	StartScreen startScreen;
	CreditScreen creditScreen;
	Background background;
	GameBackground gameB;
	
	//this is used for full screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int fullW = (int) screenSize.getWidth();
	final int fullH = (int) screenSize.getHeight();

	//dimensions of the game
	//int width = fullW, height = fullH;
	int width = 1152;
	int height = 720;
		

	//keyboard and other controls
	KeyboardControl k = new KeyboardControl();
	PS3Control ps3 = new PS3Control();
	
	//time and delays
	int time;
	int delay; //delay for button presses
	
	//player name used for csv game save
	String player;
	Motorcycle motorcycle;
	
	
	public static void main(String[] args) {
		Revenge game = new Revenge(); 
		game.init();
        game.run(); 

        System.exit(0); 
	}

	public void draw() {
		
		Graphics g = getGraphics();
		//buffer 
		Graphics buffer = backBuffer.getGraphics(); 
		buffer.setColor(Color.WHITE); 
		buffer.fillRect(0, 0, width, height);
		buffer.setColor(Color.black);
		//start screen draw and credit screen draw
		if(start){
			background.draw(buffer, 0, 0);
			if(credit){ //this is the select screen (setting/credit/info screen)
				creditScreen.draw(buffer); //display credits
					if(playerSelect){ //this should be handled somewhere else
						player = JOptionPane.showInputDialog("Current Player: " + player);
						if(player == null || player.equals("")){ //avoid empty box
							player = "Player1";
						}
						playerSelect = false;
						k.Start = false; //there is a bug here where it gets stuck in true without this (will fix later for now this is quick fix)
					}
			}
			else{
				startScreen.draw(buffer); 
			}
		}
		//start of game screens draw
		else{
			gameB.draw(buffer);
			motorcycle.draw(buffer);
		}
		
		buffer.drawString("Time: " + time, 20, 40);
		g.drawImage(backBuffer, 0, 0, this);
		
		

	}
	
	/**
	 * this method handles all the update stuff
	 */
	public void update() {
		time++;
		delay++;
		
		//this is to switch player in credit screen
		if(credit && k.pressStart() && delay > 30){
			playerSelect = true;
			delay = 0;
		}
		//start the game
		else if(k.pressStart() && delay > 30){
			start = false;
			delay = 0;
		}
		//switch to credit screen 
		if(start && k.pressSelect() && delay > 30){
			credit = !credit;
			delay = 0;
		}
		//if you are in the game this is where the controls go
		if(start == false){
			//change speed
			Camera.moveBy(10, 0); //will change later this is the speed of the motorcycle
			motorcycle.moveRt();
			
			motorcycle.pressA1(k.pressAct1()); //change the speed should be clean later (shouldnt be here)
			if(k.pressAct1()){
				if(motorcycle.x >= Camera.x + 700){
					Camera.moveBy(10, 0);
				}
			}
			else if(motorcycle.x <= Camera.x){ //move the motorcycle automatically
				motorcycle.setSpeed(10);
			}
			else{
				motorcycle.setSpeed(3);
			}

			
			if(k.pressLeft()){
				//disable for this game
				//motorcycle.moveLt(10);
				//Camera.moveBy(motorcycle.speed, 0);
			}
			if(k.pressUp()){
				if(motorcycle.y >= 288){
					motorcycle.moveUp(motorcycle.speed);
				}

			}
			if(k.pressDown()) {
				if(435 >= motorcycle.y){
					motorcycle.moveDn(motorcycle.speed);
				}
			}
			
		}
	
	}

	/**
	 * this method initializes everything
	 */
	public void init() {
		//window stuff
		setTitle("Driver's Revenge"); //title
		setSize(width, height); 
	    setFocusable(true);
	    requestFocusInWindow();
	    setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    setVisible(true); 
	    
	    //key listener for keyboard
	    addKeyListener(k);
	    
	    //buffering
	    backBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	    
	    //initialize screens
	    startScreen = new StartScreen(width,height);
	    creditScreen = new CreditScreen(width,height);
	    background = new Background(width,height);
	    gameB = new GameBackground(width,height);
	    Sound.sound1.play();

	    //camera
	    Camera.setLocation(200, 0);
	    
	    //time is a clock for keeping track of delays etc
	    time = 0;
	    delay = 0;
	    player = "Player1"; //starts with default player 'Player1'
	
	   motorcycle = new Motorcycle();
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

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;

/**
 * for now this class is a test for the ps3 remote
 * **you must have jinput ipa added - http://goo.gl/kOWfCw
 * **or else PS3Controller won't work making everything here using it crash as well
 * @author josuerojas
 *
 */
public class Game extends Applet implements KeyListener, Runnable, MouseListener{

	Thread t;	
	Image offScreen;
	Graphics off_g;
	PS3Controller player1 = new PS3Controller(1);
	PS3Controller player2 = new PS3Controller(2);
	
	
    public void init(){
    	offScreen = this.createImage(2000,1600);
		off_g = offScreen.getGraphics();
		t = new Thread(this);
		t.start();
		this.requestFocus();
    }
    /*
    public void update(Graphics g){
		g.clearRect(0, 0, 2000, 1000);
		paint(off_g);
		
		g.drawImage(offScreen, 0, 0,null);
	}
	*/
    @Override
    public void paint(Graphics g){
    	Random r = new Random();
    	String ran = "" + r.nextInt();
    	if(player1.isPressed(PS3Controller.SELECT)){
    		g.drawString("Select", 200, 100);
    	}
    	if(player1.isPressed(PS3Controller.START)){
    		g.drawString("START", 200, 120);
    	}
    	if(player1.isPressed(PS3Controller.CIRCLE)){
    		g.drawString("CIRCLE", 200, 140);
    	}
    	if(player1.isPressed(PS3Controller.SQUARE)){
    		g.drawString("SQAURE", 200, 160);
    	}
    	if(player1.isPressed(PS3Controller.TRIANGLE)){
    		g.drawString("TRIANGLE", 200, 180);
    	}
    	g.drawString("Left X" + player1.joystick(PS3Controller.L_X), 200, 200);
    	g.drawString("Left Y" + player1.joystick(PS3Controller.L_Y), 200, 220);
    	g.drawString("Right X" + player1.joystick(PS3Controller.R_X), 200, 240);
    	g.drawString("Right Y" + player1.joystick(PS3Controller.R_Y), 200, 260);
    	if(player2.isPressed(PS3Controller.SELECT)){
    		g.drawString("Select", 100, 100);
    	}
    	if(player2.isPressed(PS3Controller.START)){
    		g.drawString("START", 100, 120);
    	}
    	if(player2.isPressed(PS3Controller.CIRCLE)){
    		g.drawString("CIRCLE", 100, 140);
    	}
    	if(player2.isPressed(PS3Controller.SQUARE)){
    		g.drawString("SQAURE", 100, 160);
    	}
    	if(player2.isPressed(PS3Controller.TRIANGLE)){
    		g.drawString("TRIANGLE", 100, 180);
    	}
    	g.drawString("Left X" + player2.joystick(PS3Controller.L_X), 100, 200);
    	g.drawString("Left Y" + player2.joystick(PS3Controller.L_Y), 100, 220);
    	g.drawString("Right X" + player2.joystick(PS3Controller.R_X), 100, 240);
    	g.drawString("Right Y" + player2.joystick(PS3Controller.R_Y), 100, 260);
    }
    
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			repaint();
			try{
				t.sleep(16);
			}
			catch(Exception e){};			
		}
    	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public static void main(String args[])
	  {	
		Game ga = new Game();
		//make the window full screen
    	//g.setExtendedState(Frame.MAXIMIZED_BOTH);
		ga.setBounds(100,50,500,300);
    	//show the window
		//ga.show();
		ga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ga.setVisible(true);
		

	
	  }
	  */
}

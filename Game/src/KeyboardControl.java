
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *This class extends the Control class which has the functions that returns the keys pressed
 *has all the basic controls
 *******************************************
 *DONE
 *******************************************
 *TO DO
 *there should only be one keyboard if there are more add an exception (or do something)
 *******************************************
 *NOTES
 *you need to addKeyListener to this class to use it
 *******************************************
 *******************************************
 *******************************************
 * @author josuerojas
 *
 */

public class KeyboardControl extends Control implements KeyListener{


	//constructor is just the default constructor since there should only be one keyboard
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) Up = true;
		if(key == KeyEvent.VK_DOWN) Down = true;
		if(key == KeyEvent.VK_LEFT) Left = true;
		if(key == KeyEvent.VK_RIGHT) Right = true;
		if(key == KeyEvent.VK_A) ACT1 = true;
		if(key == KeyEvent.VK_W) ACT2 = true;
		if(key == KeyEvent.VK_D) ACT3 = true;
		if(key == KeyEvent.VK_S) ACT4 = true;
		if(key == KeyEvent.VK_P) Start = true;
		if(key == KeyEvent.VK_O) Select = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) Up = false;
		if(key == KeyEvent.VK_DOWN) Down = false;
		if(key == KeyEvent.VK_LEFT) Left = false;
		if(key == KeyEvent.VK_RIGHT) Right = false;
		if(key == KeyEvent.VK_A) ACT1 = false;
		if(key == KeyEvent.VK_W) ACT2 = false;
		if(key == KeyEvent.VK_D) ACT3 = false;
		if(key == KeyEvent.VK_S) ACT4 = false;
		if(key == KeyEvent.VK_P) Start = false;
		if(key == KeyEvent.VK_O) Select = false;		
	}
	
}

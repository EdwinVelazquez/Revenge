import java.awt.Graphics;

/**
 * this class represents the start screen and will be made of animations of the start screen
 * @author josuerojas
 *
 */
public class StartScreen {
	
	static Title t = new Title();
	static Background b = new Background();
	static int width;
	static int height;
	public StartScreen(int width, int height){
		this.width = width;
		this.height = height;

	}
	public void draw(Graphics g){
		t.draw(g, 0,0); //needs to be fix to calculate the middle for different dimensions
	}
}

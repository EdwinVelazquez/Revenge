import java.awt.Graphics;

/**
 * this class represents the start screen and will be made of animations of the start screen
 * @author josuerojas
 *
 */
public class StartScreen {
	
	//static Background b = new Background();
	static int width = 1440;
	static int height = 900;
	Title t;
	public StartScreen(int width, int height){
		this.width = width;
		this.height = height;
		t = new Title(width, height);

	}
	public void draw(Graphics g){
	//	b.draw(g, 0, 0);
		t.draw(g, 0,-60); //needs to be fix to calculate the middle for different dimension
	}
}

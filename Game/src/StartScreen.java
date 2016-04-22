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
	static int middleX;
	static int middleY;
	public StartScreen(int width, int height){
		this.width = width;
		this.height = height;
		this.middleX = width/2;
		this.middleY = height/2;
		System.out.println(width + " width " + height + " height");
	}
	public void draw(Graphics g){
		t.draw(g, 300,300);
	}
}

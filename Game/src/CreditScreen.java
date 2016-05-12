import java.awt.Graphics;
/**
 * this represents a screen in this case it is the beginning when you press select 
 * it is a credit screen which includes player scores, controls, and maybe settings if i have time
 * @author josuerojas
 *
 */
public class CreditScreen {
	//static Background b = new Background(15);
	
	static int w;
	static int h;
	Credit c;
	public CreditScreen(int w, int h){
		this.w = w;
		this.h = h;
		c = new Credit(w,h);
	}
	public void draw(Graphics g){
		//b.draw(g, 0, 0);
		c.draw(g, 0, 0);
	}

}

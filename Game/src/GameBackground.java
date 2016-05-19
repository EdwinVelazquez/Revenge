import java.awt.Graphics;


public class GameBackground {
	
	//layers
	ImageLayer trees;
	ImageLayer houses;
	ImageLayer mountains;
	ImageLayer road;
	Animation green;
	
	public GameBackground(int width, int height){
		trees = new ImageLayer("Images/Road/trees.gif",1);
		houses = new ImageLayer("Images/Road/houses.gif", 2);
		mountains = new ImageLayer("Images/Road/mountains.gif", 8);
		road = new ImageLayer("Images/Road/road.png");
		road.setY(288);
		green = new Animation("Images/Road/green", 10,1,".jpg",width,height);
		
	}
	
	public void draw(Graphics g){
		//should be fill the screen
		green.draw(g, 0, 0);
		mountains.drawInfinite(g);
		houses.drawInfinite(g);
		road.drawInfinite(g);
		trees.drawInfinite(g);
		//draw road here
	}
	

}

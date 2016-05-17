/**
 * this class is used for layers (background layers) for example the moon will be all the way back and move according to that
 */
import java.awt.*;

public class ImageLayer
{
   private Image image;

   private float x = 0;
   private float y = 0;

   private float d = 1;
   private int endW;
   String filename;


   public ImageLayer(String filename)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);
	  this.filename = filename;
	  endW =  this.getWidth();
	  System.out.println(endW);
   }

   public ImageLayer(String filename, float distance)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);

	  this.filename = filename;
      setDistance(distance);
      //return -1 because it cannot get the width yet
	  endW = this.getWidth();
	  System.out.println(endW);
   }

   public void setX(float x)
   {
      this.x = x;
   }

   public void setY(float y)
   {
      this.y = y;
   }

   public void setDistance(float distance)
   {
      d = distance;
   }

   public int getWidth(){
	   return image.getWidth(null);
   }
   public void draw(Graphics g){
	   for(int i = 0; i < 5; i++)
	      {
	         g.drawImage(image, i*image.getWidth(null) +(int)(x - Camera.x / d), (int)(y - Camera.y / d), null);
	      }
   }
   /**
    * NEEDS TO BE FIX FOR FLICKERING AND NOT MOVING LEFT
    * @param g
    */
   public void drawInfinite(Graphics g)
   {

	   this.endW =  this.getWidth();
      for(int i = 0; i < 3; i++)
      {
    	  int pointScreenX =  i*image.getWidth(null) +(int)(x - Camera.x / d);
    	  int endWScreenX = endW + (int)(x - Camera.x / d);
         g.drawImage(image,pointScreenX, (int)(y - Camera.y / d), null);
         
         if(pointScreenX < -endW){
        	// int offset = -endW - point screen
        	 //drew it on top of the first
        	 //there is an offset that causes the flickering
        	 
        	 x += endW;
         }
         /*
         //creating it for the opposite direction makes it flicker because of the contradiction
         else {
         	// int offset = -endW - point screen
         	 //drew it on top of the first
         	 //there is an offset that causes the flickering
         	 x -= endW;
          }
          */
         System.out.println(pointScreenX + " " + filename + " width  = " + image.getWidth(null));
         
      }
   }
}

import java.awt.*;

public class ImageLayer
{
   private Image image;

   private float x = 0;
   private float y = 0;

   private float d = 1;


   public ImageLayer(String filename)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);
   }

   public ImageLayer(String filename, float distance)
   {
	  image = Toolkit.getDefaultToolkit().getImage(filename);

      setDistance(distance);
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

   public void draw(Graphics g)
   {

      for(int i = 0; i < 5; i++)
      {
         g.drawImage(image, i*image.getWidth(null) +(int)(x - Camera.x / d), (int)(y - Camera.y / d), null);
      }
   }
}
import java.awt.*;


public class ImageLayer
{
   Image image;

   int x;
   int y;
   int z;


   public ImageLayer(String name, int x, int y, int z)
   {
      image = Toolkit.getDefaultToolkit().getImage(name);

      this.x = x;
      this.y = y;
      this.z = z;
   }

   public void draw(Graphics g)
   {
      for(int i = 0; i < 20; i++)
         g.drawImage(image, (x - Camera.x) / z + 720*i, (y - Camera.y) / z, null);
   }

}

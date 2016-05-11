import java.awt.*;


public class Animation
{


   Image[] image;


   int next = 0;

   int duration;
   int count = 0;


   public Animation(String name, int duration, int size)
   {
      image = new Image[size];

      for(int i = 0; i < image.length; i++)

         image[i] = Toolkit.getDefaultToolkit().getImage(name + (i+1) + ".gif");

      this.duration = duration;
   }


   public Image getNextImage()
   {
      count++;

      if (count == duration)
      {
         next++;

         if(next == image.length-1)  next = 0;

         count = 0;
      }

      return image[next];
   }

   public Image getStillImage()
   {
      return image[0];
   }
}
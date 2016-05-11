import java.awt.*;
import java.applet.Applet;


public class Animation
{
   Image[] image;

   int current = 0;

   int delay;

   int countdown;


   public Animation(String name, int count, int delay, Applet applet)
   {
      // Create array of count images
      image = new Image[count];

      this.delay = delay;

      countdown = delay;

      // Load count images sharing the same suffix in their filename
      for(int i = 0; i < image.length; i++)
         image[i] = applet.getImage(applet.getDocumentBase(), name + i + ".GIF" );

   }


   public Image getNextImage()
   {
      if (countdown == 0)
      {
          current++;

          if(current > 4) current = 1;

          countdown = delay;
      }

      countdown--;

      return image[current];
   }


   public Image getStillImage()
   {
      return image[0];
   }

}
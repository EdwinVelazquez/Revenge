import java.awt.*;

public class Helicopter extends PolygonModel
{
   public Helicopter(int x, int y, int angle)
   {
      super(x, y, angle);
   }

   public Color[] getColor()
   {
      Color[] c =
      {
         Color.green,
         Color.white,
         Color.white,
         Color.white,
         Color.white,
         Color.white,
      };

      return c;
   }
   public int[][] getxStruct()
   {
      int[][] xStruct =
      {
         {-50, 50, 50, -50},
         {40, 50, 50, 40},
         {-150, -50, -50, -150},
         {-160, -150, -150, -160},
         {-5, 5, 5, -5},
         {-5, 5, 5, -5}
      };

      return xStruct;
   }

   public int[][] getyStruct()
   {
      int[][] yStruct =
      {
         {30, 30, -30, -30},
         {20, 20, -20, -20},
         {10, 10, -10, -10},
         {25, 25, -25, -25},
         {100, 100, -100, -100},
         {5, 5, -5, -5}
      };

      return yStruct;
   }







}




import java.awt.*;

public class Tank extends PolygonModel
{
   public Tank(int x, int y, int angle)
   {
      super(x, y, angle);
   }

   public Color[] getColor()
   {
      Color[] c =
      {
         Color.green,
         Color.darkGray,
         Color.darkGray,
         Color.black,
      };

      return c;
   }

   public int[][] getxStruct()
   {
      int[][] xStruct =
      {
         {-50, 50, 50, -50},
         {-40, -40, 40, 40},
         {-40, -40, 40, 40},
         { 40,  15, 15, 40},
      };

      return xStruct;
   }

   public int[][] getyStruct()
   {
      int[][] yStruct =
      {
         {30, 30, -30, -30},
         {30, 40, 40, 30},
         {-30, -40, -40, -30},
         {3, 3, -3, -3},
      };

      return yStruct;
   }


   public void draw(Graphics g)
   {
      super.draw(g);


      g.setColor(Color.white);
      g.fillOval(x-15, y-15, 30, 30);

      g.setColor(Color.black);
      g.drawOval(x-15, y-15, 30, 30);
   }


   public void rotateGunBy(int angle)
   {
      A[3] += angle;
   }






}





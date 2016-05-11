public class Camera
{
   static int x = 0;
   static int y = 0;


   public static void moveLeftBy(int dx)
   {
      x -= dx;
   }

   public static void moveRightBy(int dx)
   {
      x += dx;
   }

}
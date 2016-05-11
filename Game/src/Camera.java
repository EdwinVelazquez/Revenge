public class Camera
{
   public static int x;
   public static int y;


   public static void setLocation(int x, int y)
   {
      Camera.x = x;
      Camera.y = y;
   }

   public static void moveBy(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void moveLeft(int dx)
   {
      x -= dx;
   }

   public void moveRight(int dx)
   {
      x += dx;
   }
}
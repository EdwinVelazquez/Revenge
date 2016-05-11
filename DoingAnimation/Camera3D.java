public class Camera3D
{
   static int x = 0;
   static int y = 0;
   static int z = 0;


   public static void moveBy(int dx, int dy, int dz)
   {
      x += dx;
      y += dy;
      z += dz;
   }

}

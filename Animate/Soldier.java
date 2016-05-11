public class Soldier extends Sprite
{

   static String[] pose =
      {
         "lt",
         "rt",
         "dn",
         "up"
      };

   public Soldier(int x, int y, int duration)
   {
      super(x, y, 20, 50, "g", pose, duration, 5);
   }

}
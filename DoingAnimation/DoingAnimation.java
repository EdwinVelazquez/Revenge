import java.awt.*;
import java.awt.event.*;

public class DoingAnimation extends AnimationApplet
{

   Soldier[] soldier = new Soldier[100];

   BattleLord blord;


   Sprite3D[] tree = new Sprite3D[25];


   public void initialize()
   {

       for(int i = 0; i < tree.length; i++)
          tree[i] = new Sprite3D(100 + 40 * (i % 5), 20, 100 + 40 * (i / 5), 50, 100 ,"tree2a", this);



       for(int i = 0; i < soldier.length; i++)
       {
          soldier[i] = new Soldier(50 + (20*i) % 200, 400 + 60*(i / 10), this);
       }

       blord = new BattleLord(500, 100, this);
   }


   public void moveObjects()
   {


      if(lt_pressed)  Camera3D.moveBy(-10, 0, 0);
      if(rt_pressed)  Camera3D.moveBy( 10, 0, 0);
      if(up_pressed)  Camera3D.moveBy(0, 0, -10);
      if(dn_pressed)  Camera3D.moveBy(0, 0, 10);

  /*
      for(int i = 0; i < soldier.length; i ++)
      {
         if(lt_pressed)  soldier[i].moveLeftBy(1);
         if(rt_pressed)  soldier[i].moveRightBy(1);
         if(up_pressed)  soldier[i].moveUpBy(1);
         if(dn_pressed)  soldier[i].moveDownBy(1);
      }

      if(lt_pressed)  blord.moveLeftBy(1);
      if(rt_pressed)  blord.moveRightBy(1);
      if(up_pressed)  blord.moveUpBy(1);
      if(dn_pressed)  blord.moveDownBy(1);
  */
   }


   public void paint(Graphics g)
   {

      for(int i = 0; i < tree.length; i++)
         tree[i].draw(g);

/*       for(int i = 0; i < soldier.length; i ++)
          soldier[i].draw(g);


       blord.draw(g);
*/
   }







}

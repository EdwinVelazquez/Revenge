import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DrawLines extends Applet implements Runnable, KeyListener, MouseListener
{
   Image    offScreen;
   Graphics off_g;



   double d = 0;


   Image background = Toolkit.getDefaultToolkit().getImage("wSpy_Hunter45.gif");


   Tank tank1 = new Tank(100, 100, 0);


   Helicopter heli1 = new Helicopter(300, 500, 0);



   Line L1 = new Line(-1000, 100, -100, 100);
   Line L2 = new Line(-100, 100, -100, 200);
   Line L3 = new Line(-100, 200, 100, 200);
   Line L4 = new Line( 100, 100, 100, 200);
   Line L5 = new Line( 1000, 100,  100, 100);

   Circle c = new Circle(500, 300, 20, 90);

   boolean upPressed = false;
   boolean dnPressed = false;
   boolean ltPressed = false;
   boolean rtPressed = false;

   Thread t;


   //------------------------------------------------------------------------//

   public void init()
   {
      offScreen = createImage(2000, 1600);
      off_g     = offScreen.getGraphics();

      addMouseListener(this);

      addKeyListener(this);

      requestFocus();


      Camera.setup(0, -100, 20, 90);

      t  = new Thread(this);

      t.start();
   }


   //------------------------------------------------------------------------//

   public void run()
   {
      while(true)
      {
         if(upPressed) Camera.moveForwardBy(4);
         if(dnPressed) Camera.moveForwardBy(-2);
         if(ltPressed) Camera.rotateBy(-2);
         if(rtPressed) Camera.rotateBy(2);

         if(Camera.hasCollidedWith(L3))   Camera.pushedBackFrom(L3);
         //if(Camera.hasCollidedWith(L2))   Camera.pushedBackFrom(L2);



         try
         {
            t.sleep(16);
         }
         catch(Exception x){};


         repaint();
      }

   }

   //------------------------------------------------------------------------//

   public void paint(Graphics g)
   {
       //g.drawImage(background,0, 0, null);
       //tank1.draw(g);

       //heli1.draw(g);

       L1.draw(g);
       L2.draw(g);
       L3.draw(g);
       L4.draw(g);
       L5.draw(g);

       Camera.draw(g);


   }

   //------------------------------------------------------------------------//

   public void update(Graphics g)
   {
      off_g.clearRect(0, 0, 2000, 1600);

      paint(off_g);

      g.drawImage(offScreen, 0, 0, null);

   }

   //------------------------------------------------------------------------//

   public void mousePressed(MouseEvent e)
   {
      int x = e.getX();
      int y = e.getY();

      d = L1.distanceTo(x, y);

   }

   //------------------------------------------------------------------------//

   public void mouseReleased(MouseEvent e)
   {
   }

   //------------------------------------------------------------------------//

   public void mouseClicked(MouseEvent e)
   {
   }

   //------------------------------------------------------------------------//

   public void mouseEntered(MouseEvent e)
   {
   }

   //------------------------------------------------------------------------//

   public void mouseExited(MouseEvent e)
   {
   }

   //------------------------------------------------------------------------//

   public void keyPressed(KeyEvent e)
   {
      int code = e.getKeyCode();

      if(code == e.VK_UP)     upPressed = true;
      if(code == e.VK_DOWN)   dnPressed = true;
      if(code == e.VK_LEFT)   ltPressed = true;
      if(code == e.VK_RIGHT)  rtPressed = true;
   }

   //------------------------------------------------------------------------//

   public void keyReleased(KeyEvent e)
   {
      int code = e.getKeyCode();

      if(code == e.VK_UP)     upPressed = false;
      if(code == e.VK_DOWN)   dnPressed = false;
      if(code == e.VK_LEFT)   ltPressed = false;
      if(code == e.VK_RIGHT)  rtPressed = false;
   }

   //------------------------------------------------------------------------//

   public void keyTyped(KeyEvent e)
   {
   }

   //------------------------------------------------------------------------//

   public void drawPoly(int[] xpoints, int[] ypoints, Graphics g)
   {
      for(int i = 0; i < xpoints.length; i ++)

         drawLine
         (
            xpoints[i], ypoints[i],
            xpoints[(i+1)% xpoints.length], ypoints[(i+1)%xpoints.length],
             g
         );
   }

   //------------------------------------------------------------------------//


   /*
   public void drawLine(int x1, int y1, int x2, int y2, Graphics g)
   {
      int xm = (x1 + x2) / 2;
      int ym = (y1 + y2) / 2;

      drawPoint(xm, ym, g);

      if((Math.abs(x1 - x2) > 2) || (Math.abs(y1 - y2) > 2))
      {
         drawLine(x1, y1, xm, ym, g);
         drawLine(xm, ym, x2, y2, g);
      }
   }
*/

   //------------------------------------------------------------------------//

   public void drawLine(int x1, int y1, int x2, int y2, Graphics g)
   {
      int dy = y2 - y1;
      int dx = x2 - x1;

      if(Math.abs(dx) > Math.abs(dy))
      {
         if(x1 > x2)
         {
            int temp = y1;
            y1 = y2;
            y2 = temp;

            temp = x1;
            x1 = x2;
            x2 = temp;
         }
          double slope = dy / (double)dx;


         double y = y1;

         for(int x = x1; x < x2; x++)
         {
             drawPoint(x, (int)y, g);

             y += slope;
         }
      }
      else
      if(Math.abs(dy) > Math.abs(dx))
      {
         if(y1 > y2)
         {
            int temp = y1;
            y1 = y2;
            y2 = temp;

            temp = x1;
            x1 = x2;
            x2 = temp;
         }

         double recip =  dx / (double) dy;

         double x = x1;

         for(int y = y1; y < y2; y++)
         {
            drawPoint((int)x, y, g);

             x += recip;
         }
      }
      else
      if(Math.abs(dx) > 0)
      {
          int x = x1;

          int dd = 1;

          if (dx < 0)  dd = -1;

         for(int y = y1; y < y2; y++)
         {
            drawPoint(x, y, g);

             x += dd;
         }
      }
      else
      {
         drawPoint(x1, y1, g);
      }

   }

   //------------------------------------------------------------------------//

   public void drawPoint(int x, int y, Graphics g)
   {
      g.drawLine(x, y, x, y);
   }

   //------------------------------------------------------------------------//

   public void drawHLine(int x1, int x2, int y, Graphics g)
   {
       for(int x = x1; x < x2; x++)

          drawPoint(x, y, g);

       for(int x = x2; x < x1; x++)

          drawPoint(x, y, g);
   }

   //------------------------------------------------------------------------//

   public void drawVLine(int x, int y1, int y2, Graphics g)
   {
      for(int y = y1; y < y2; y++)

         drawPoint(x, y, g);

      for(int y = y2; y < y1; y++)

         drawPoint(x, y, g);
   }

   //------------------------------------------------------------------------//


   public void drawRect(int x, int y, int w,  int h, Graphics g)
   {
      drawVLine(x,    y, y+h, g);
      drawHLine(x,  x+w,   y, g);
      drawVLine(x+w,  y, y+h, g);
      drawHLine(x,  x+w, y+h, g);

   }
}



   /*
      g.drawLine(10, 10, 100, 100);

      g.drawRect(100, 100, 100, 50);


      g.drawOval(100, 100, 100, 50);


      int[] xpoints = {200, 300, 320, 280, 150};
      int[] ypoints = {100,  90, 200, 250, 200};


      g.drawPolygon(xpoints, ypoints, 5);
   */


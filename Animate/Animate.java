import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.io.*;


public class Animate extends Applet implements MouseListener, MouseMotionListener, Runnable, KeyListener
{

   ImageLayer mountains = new ImageLayer("mountains.gif", 0, 0, 10);
   ImageLayer houses    = new ImageLayer("houses.gif", 0, 0, 5);
   ImageLayer trees     = new ImageLayer("trees.gif", 0, 0, 2);



   Soldier[] sprite = new Soldier[10];


   Rect selector = new Rect(0, 0, 0, 0);


   int selected = 0;

   boolean ltPressed = false;
   boolean rtPressed = false;
   boolean upPressed = false;
   boolean dnPressed = false;


   int mx = 0;
   int my = 0;

   Thread t;

   Image    offscreen;
   Graphics offscreen_g;


   public void init()
   {
      offscreen   = createImage(1000, 800);
      offscreen_g = offscreen.getGraphics();


      for(int i = 0; i < sprite.length; i++)

         sprite[i] = new Soldier (100 + i*30, 300, 4);

      t = new Thread(this);

      t.start();


      addKeyListener(this);

      addMouseListener(this);

      addMouseMotionListener(this);

      requestFocus();
   }


   public void update(Graphics g)
   {
      offscreen_g.clearRect(0, 0, 1000, 800);

      paint(offscreen_g);

      g.drawImage(offscreen, 0, 0, this);
   }


   public void paint(Graphics g)
   {
     mountains.draw(g);
     houses.draw(g);
     trees.draw(g);


     for(int i = 0; i < sprite.length; i++)

         sprite[i].draw(g);


     selector.draw(g);

   }


   public void run()
   {

      while(true)
      {

         if(sprite[0].x - Camera.x < 400)
         {

            if(rtPressed) Camera.moveRightBy(8);
         }
         else
         {
            if(rtPressed) Camera.moveRightBy(10);
         }

         if(sprite[0].x - Camera.x > 600)
         {
            if(ltPressed)  Camera.moveLeftBy(10);
         }
         else
         {
            if(ltPressed)  Camera.moveLeftBy(8);

         }


         for(int i = 0; i < sprite.length; i++)
         {
            if(sprite[i].selected)
            {

               if(ltPressed)
               {
                  sprite[i].moveLeftBy(10);
               }
               if(rtPressed)
               {
                  sprite[i].moveRightBy(10);
               }
               if(upPressed)
               {
                  sprite[i].moveUpBy(10);
               }
               if(dnPressed)
               {
                  sprite[i].moveDownBy(10);
               }
            }
         }

         try
         {
            t.sleep(50);
         }
         catch(Exception x){};

         repaint();


      }

   }


   public void keyPressed(KeyEvent e)
   {
      if (e.getKeyCode() == e.VK_LEFT)  ltPressed = true;

      if (e.getKeyCode() == e.VK_RIGHT) rtPressed = true;

      if (e.getKeyCode() == e.VK_UP)    upPressed = true;

      if (e.getKeyCode() == e.VK_DOWN)  dnPressed = true;
   }

   public void keyReleased(KeyEvent e)
   {
      if (e.getKeyCode() == e.VK_LEFT)  ltPressed = false;

      if (e.getKeyCode() == e.VK_RIGHT) rtPressed = false;

      if (e.getKeyCode() == e.VK_UP)    upPressed = false;

      if (e.getKeyCode() == e.VK_DOWN)  dnPressed = false;
   }


   public void keyTyped(KeyEvent e)
   {

   }


   public void mouseDragged (MouseEvent e)
   {
      int nx = e.getX();
      int ny = e.getY();

      int dx = nx - mx;
      int dy = ny - my;

      selector.resizeBy(dx, dy);


      for(int i = 0; i < sprite.length; i++)
      {
         if(selector.overlaps(sprite[i]))

            sprite[i].selected = true;

         else

            sprite[i].selected = false;
      }

      mx = nx;
      my = ny;


   }

   public void mouseMoved (MouseEvent e)
   {
   }


   public void mousePressed (MouseEvent e)
   {
      mx = e.getX();
      my = e.getY();

      selector.moveTo(mx, my);

      selector.setSize(0, 0);
   }

   public void mouseReleased (MouseEvent e)
   {
      selector.setSize(-1, -1);

   }

   public void mouseClicked (MouseEvent e)
   {

   }

   public void mouseEntered (MouseEvent e)
   {

   }

   public void mouseExited (MouseEvent e)
   {

   }


}
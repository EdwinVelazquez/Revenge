//----------------------------------------------------------------------------//
// Copyright - Brian Murphy - 2005                                            //
//----------------------------------------------------------------------------//
//----------------------------------------------------------------------------//
// Abstract Sprite that can move in 4 directions with several images for each //
//----------------------------------------------------------------------------//
// Images determined in derived classes                                       //
//----------------------------------------------------------------------------//

import java.awt.*;

//----------------------------------------------------------------------------//

public abstract class Sprite4WayAnimatedImg extends Sprite4Way
{
   //-------------------------------------------------------------------------//

   protected Image [] up_img;
   protected Image [] dn_img;
   protected Image [] lt_img;
   protected Image [] rt_img;

   // This is a cheat
   protected boolean moving = false;

   protected int frame = 0;
   protected int pacer = 0;

   public int frames;
   public int delay;


   //-------------------------------------------------------------------------//

   public Sprite4WayAnimatedImg(int x, int y, int dir, int frames, int delay)
   {
      super(x, y, dir);

      this.frames = frames;
      this.delay = delay;
   }

   //-------------------------------------------------------------------------//

   public Sprite4WayAnimatedImg(String filename,String extension, int x, int y, int dir, int frames, int delay)
   {
      super(x, y, dir);

      this.frames = frames;
      this.delay  = delay;

      up_img = loadImageSet(filename + "_up",extension);
      dn_img = loadImageSet(filename + "_dn",extension);
      lt_img = loadImageSet(filename + "_lt",extension);
      rt_img = loadImageSet(filename + "_rt",extension);
   }

//-------------------------------------------------------------------------//

   public void moveUp(int dy)
   {
      super.moveUp(dy);
      moving = true;
   }

   //-------------------------------------------------------------------------//

   public void moveDn(int dy)
   {
      super.moveDn(dy);
      moving = true;
   }

   //-------------------------------------------------------------------------//

   public void moveLt(int dx)
   {
      super.moveLt(dx);
      moving = true;
   }

   //-------------------------------------------------------------------------//

   public void moveRt(int dx)
   {
      super.moveRt(dx);
      moving = true;
   }

   //-------------------------------------------------------------------------//

   public void draw(Graphics g)
   {
      super.draw(g);

      if (moving)
      {
         if (pacer == delay)
         {
            frame = (frame + 1) % frames;
            pacer = 0;
         }

         pacer++;
         moving = false;
      }
      else
      {
         frame = frames;
         pacer = delay;
      }
   }

   //-------------------------------------------------------------------------//

   public void drawUp(Graphics g)
   {
      g.drawImage(up_img[frame], x - Camera.x, y - Camera.y, null);
   }

   //-------------------------------------------------------------------------//

   public void drawDn(Graphics g)
   {
      g.drawImage(dn_img[frame], x - Camera.x, y - Camera.y, null);
   }

   //-------------------------------------------------------------------------//

   public void drawLt(Graphics g)
   {
      g.drawImage(lt_img[frame], x - Camera.x, y - Camera.y, null);
   }

   //-------------------------------------------------------------------------//

   public void drawRt(Graphics g)
   {
      g.drawImage(rt_img[frame], x - Camera.x, y - Camera.y, null);
   }

   //-------------------------------------------------------------------------//

   public Image[] loadImageSet(String filename, String extention)
   {
      Image[] img = new Image[frames+1];

      for (int i = 0; i < frames + 1; i++)
         img[i] = Toolkit.getDefaultToolkit().getImage(filename + "_" + i + extention);

      return img;
   }
   
   //-------------------------------------------------------------------------//
}

   

//----------------------------------------------------------------------------//
//----------------------------------------------------------------------------//
// Copyright - Brian Murphy - 2005                                            //
//----------------------------------------------------------------------------//
//----------------------------------------------------------------------------//
// Abstract Sprite that can move in 4 directions with a still drawing for each//
//----------------------------------------------------------------------------//

import java.awt.*;

//----------------------------------------------------------------------------//

public abstract class Sprite4Way
{
   //-------------------------------------------------------------------------//

   protected int x;
   protected int y;

   protected int direction;

   public final static int UP = 0;
   public final static int DN = 1;
   public final static int LT = 2;
   public final static int RT = 3;

   public final static int NUMBER_OF_DIRECTIONS = 4;

   //-------------------------------------------------------------------------//

   public Sprite4Way (int x, int y, int direction)
   {
      this.x = x;
      this.y = y;

      this.direction = direction % 4;
   }

   //-------------------------------------------------------------------------//

   public void moveUp(int dy)
   {
      direction = UP;
      y -= dy;
   }

   //-------------------------------------------------------------------------//

   public void moveDn(int dy)
   {
      direction = DN;
      y += dy;
   }

   //-------------------------------------------------------------------------//

   public void moveLt(int dx)
   {
      direction = LT;
      x -= dx;
   }

   //-------------------------------------------------------------------------//

   public void moveRt(int dx)
   {
      direction = RT;
      x += dx;
   }

   //-------------------------------------------------------------------------//

   public void draw(Graphics g)
   {
      if (direction == UP) drawUp(g);
      else
      if (direction == DN) drawDn(g);
      else
      if (direction == LT) drawLt(g);
      else
      if (direction == RT) drawRt(g);
      else;

   }

   //-------------------------------------------------------------------------//

   public abstract void drawDn(Graphics g);
   public abstract void drawUp(Graphics g);
   public abstract void drawLt(Graphics g);
   public abstract void drawRt(Graphics g);

   //-------------------------------------------------------------------------//

}

//----------------------------------------------------------------------------//

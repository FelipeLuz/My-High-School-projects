package game;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Actor 
{
  protected int x,y;
  protected int width,height;
  protected String[] spriteNames;
  protected Stage stage;
  protected SpriteManager spriteManager;
  protected int currentFrame;
  protected int frameSpeed, t;
  protected boolean remove;
  
  public Actor(Stage stage)
  {
    this.stage=stage;
    spriteManager=stage.getSpriteManager();
    currentFrame = 0;
    frameSpeed = 1;
    t = 0;
  }
  public void paint(Graphics2D g)
  {
      g.drawImage(spriteManager.getSprite(spriteNames[currentFrame]),x,y,stage);
  }
  
  public void setRemove()
  {
      remove = true;
  }
  public boolean isSetToRemove()
  {
      return remove;
  }
  
  public int getX()
  {
      return x;  
  }
  public void setX(int i)
  {
      x=i;
  }
  public int getY()
  {
      return y;
  }
  
  public void setY(int i)
  {
      y=i;
  }
  public int getFrameSpeed()
  {
      return frameSpeed;
  }
  public void setFrameSpeed(int i)
  {
      frameSpeed = i;
  }
  
  public void setSpriteNames(String[]names)
  {
      spriteNames = names;
      height = 0;
      width = 0;
      for (int i = 0;i  names.length; i++)
      {
          BufferedImage image = spritemanager.getSprite(spriteNames[i]);
          height = Math.max(height, image.getHeight());
          width = Math.max(width, image.getWidth());
      }
  }
  
  public int getHeight()
  {
      return height;
  }
  
  public void setHeight(int i)
  {
      height = i;
  }
  
  public void getWidth()
  {
      return width;
  }
  
  public void setWidth(int i)
  {
      width = i;
  }
  public Rectangle getBounds()
  {
      return new Rectangle(x,y,width,height);
  }
  public void collision(Actor a)
  {
      
  }
  public void act()
  {
      t++;
      if (t%frameSpeed==0)
      {
          t=0;
          currentFrame=(currentFrame+1)%spriteNames.length;
      }
  }
  }
  
  }
}

package game;
import java.awt.event.KeyEvent;
public class Player extends Actor
{
    protected int vx;
    protected int vy;
    protected static final int PLAYER_SPEED = 4;
    private boolean up, down, left, right;
    private int score = 0;


public Player (Stage stage)
{
    super (stage);
    setSpriteNames (new String[]{"img ship.gif"});  
}
public void act ()
{
    super.act();
    x+=vx;
    y+=vy;
    
    if(x<0)
        x=0;
    if (x > Stage.WIDTH - getWidth())
        x = Stage.WIDTH - getWidth();
      if(x<0)
        x=0;
    if (x > Stage.PLAY_WIDTH - getWidth())
        x = Stage.PLAY_WIDTH - getWidth();
}

protected void updateSpeed()
{
    vx = 0;
    vy = 0;
    if (down)
        vy = PLAYER_SPEED;
    if (up)
        vy = -PLAYER_SPEED;
    if (left)
        vy = -PLAYER_SPEED;
    if (right)
        vy = PLAYER_SPEED;
}

public void keyReleased (KeyEvent e)
{
    switch (e.getKeyCode())
    {
        case KeyEvent.VK_UP :up = false;
            break;
        case KeyEvent.VK_DOWN :down = false;
            break;
        case KeyEvent.VK_LEFT :left = false;
            break;
        case KeyEvent.VK_RIGHT :right = false;
            break;
    }
    updateSpeed();
}

public void keyPressed (KeyEvent e)
{
    switch (e.getKeyCode())
    {
        case KeyEvent.VK_UP :up = true;
            break;
        case KeyEvent.VK_DOWN :down = true;
            break;
        case KeyEvent.VK_LEFT :left = true;
            break;
        case KeyEvent.VK_RIGHT :right = true;
            break;
        case KeyEvent.VK_SPACE :fire(); 
            break;            
    }
    updateSpeed();
}
public void fire()
{
    Shot shot = new Shot (stage);
    shot.setX(x+25);
    shot.setY(y+shot.getHeight());
    stage.addActor(shot);
    stage.getSoundManager().playSong("sound/shot.wav");
}

public int getScore()
{
    return score;
}

public void setScore (int i)
{
    score = 1;
}

public void addScore (int i)
{
    score = score +i;
}

public int getVX()
{
    return vx;
}

public void setVX (int i)
{
    vx = i;
}

public int getVY()
{
    return vy;
}

public void setVY(int i)
{
    vy = 1; 
}

public void collision (Actor a)
{
    if (a instanceof Alien)
        stage.gameOver();
}


}
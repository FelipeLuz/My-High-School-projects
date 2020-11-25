package game;
public class Alien extends Actor
{
    protected int vx;
    protected int vy;
    
    public Alien (Stage stage)
    {
        super (stage);
        setSpriteNames(new String[] {"img/alien1.gif","img alien2.gif"});
        setFrameSpeed(35);
    }
 
    public void act()
    {
        super.act();
        x+=vx;
        y+=vx;
        if (x>Stage.WIDHT - getWidht())
        {
            vx=-vx;
            vx=-vx+1;
        }
        if (y<0)
            vy=0;
            if (y>Stage.PLAY_HEIGHT - getHeight())
                stage.gameOver();
    }
    
    public void spawn()
    {
        Alien a = new Alien (stage);
        a.setx(1);
        a.setY ((int)(Math.random()* Stage.PLAY_HEIGHT/2));
        a.setY ((int)(Math.random()*20-10));
        stage.addActor(a);
    }
    
    public int getVX()
    {
        return vx;
    }      
    
    public void collision (Actor a)
    {
        if (a instanceof Shot)
        {
            setRemove();
            spawn();
            stage.getPlayer().addScore (20);
            stage.getSoundManager().playSong ("sound/defeat.wav");
        }
    }
}

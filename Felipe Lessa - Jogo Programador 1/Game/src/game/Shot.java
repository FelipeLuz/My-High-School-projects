package game;
public class Shot extends Actor
{
   protected static final int SHOT_SPEED=10;
    
   public Shot(Stage stage)
   {
     super(stage);
     setSpriteNames(new String[]{"img/shot.gif"});
   } 
   
   public void act()
   {
     super.act();
     y-=SHOT_SPEED;
     if(y < 0)
         setRemove();
   }
}

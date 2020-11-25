package game;
import java.awt.Canvas;
import java.awt .Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
        
public class Game extends Canvas implements Stage, KeyListener
   {
      private BufferStrategy strategy;
      private SpriteManager spriteManager;
      private SoundManager soundManager;
      private ArrayList actors;
      private Player player;
      private long time;
      private boolean gameOver = false;
      
      public Game()
      {
          spriteManager = new SpriteManager();
          soundManager = new SoundManager();
          
          JFrame window = new JFrame("Guerra espacial");
          JPanel panel = (JPanel)window.getContentPane();
          setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
          panael.setPreferredSize(new Dimension(Stage.WIDTH,Stage.HEIDHT));
          panel.setLayout(null);
          panel.add(this);
          
          window.setBounds(0,0, Stage.WIDTH, Stage.HEIGHT);
          window.setVisible(true);
          window.setResizable(false);
          window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          creatBufferStrategy(2);
          strategy = getBufferStrategy();
          
          setIgnoreRepaint(true);
          requestFocus();
          
          addKeyListener(this);
      }
 
   public void initStage()
   {
       actors = new ArrayList();
       for (int i = 0;i < 10;i++)
       {
          Alien alien = new Alien(this);
          alien.setX(i+10);
          alien.setY(i*20);
          alien.setVx((int)(Math.random()*20 - 10));
          actors.add(alien);
       }
      player = new Player(this);
      player.setX(Stage.WIDTH/2);
      player.setY(Stage.HEIGHT - 3*player.getHeight());
      soundManager.loopSong("sound/zerowing.mid");
   }
   
   public void addActor(Actor a)
     {
       actors.add(a);
     }
   
   public void updateStage()
   {
       int i = 0;
       while (i < actors.size())
       {
         Actor alien = (Actor)actors.get(i);
         if( alien.isSetToRemove())
             actors.remove(i);
         else
         {
             alien.act();
             i++;
         }
       }
       player.act();
   }
   
   public void checkCollision()
   {
       Rectangle playerBounds = player.getBounds();
       for (int i = 0;i<actors.size();i++)
       {
           Actor a1 = (Actor)actors.get(i);
           Rectangle r1 = a1.getBounds();
           if(r1.intersects(playerBounds))
           {
               player.collision(a1);
               a1.collision(player);
           }
           
          for (int j =i + 1 ;j<actors.size();j++) 
          {
           Actor a2 = (Actor)actors.get(j);
           Rectangle r2 = a2.getBounds();
           if(r1.intersects(r2))
           {
               a1.collision(a2);
               a2.collision(a1);
           }
          }     
       }
    }
    
    public void gameOver()
    {
        gameOver = true;
    }
   
    public void paintScore (Graphics2D g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0, Stage.PLAY_HEIGHT, 800, (Stage.HEIGHT - Stage.PLAY_HEIGHT));
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.setPaint(Color.black);
        g.drawString("Pontos", 20, Stage.PLAY_HEIGHT+20);
        g.setPaint(Color.YELLOW);
        g.drawString(player.getScore()+"", 120, Stage.PLAY_HEIGHT +20);
    }
    
    public void paintStage()
    {
        Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
        for (int i = 0;i < actors.size();i++)
        {
            Actor m = (Actor)actors.get(i);
            m.paint(g);
        }
        player.paint(g);
        paintScore(g);
        strategy.show();
    }
    
    public void paintGameOver()
    {
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 900);
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.drawString("VOCÊ MORREU, SE FUDEU AUHUHAUHUAH" ,Stage.WIDHT/2-50,Stage.HEIGHT/2);
        strategy.show();
    }
    
    public SpriteManager getSpriteManager()
    {
        return spriteManager;
    }
    
    public SoundManager getSoundManager()
    {
        return soundManager;
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void keypressed(KeyEvent e)
    {
        player.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e)
    {
        player.keyReleased(e);
    }
    public void game()
    {
        time = 1000;
        initStage();
        while (isVisible()&&!gameOver)
        {
            long startTime = System.currentTimeMillis();
            updateStage();
            checkCollision();
            paintStage(); 
            time = System.currentTimeMillis()- startTime;
            try
            {
                Thread.sleep(17);
            }catch(InterruptedException e){}
        }
        paintGameOver();
    }
    
    public static void main (String arg[])
    {
        Game inv = new Game();
        inv.game();
    }
    
    public static void main(String[] args) {

    }
   }

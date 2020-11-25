package game;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SpriteManager extends ResourceCache
{
    protected Object loadResource(URL url)
    {
      try
      {return ImageIO.read(url);}
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Erro ao carregar o jogo."+"Por favor verifique a instalação","Erro",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        return null;
      }
    }
    
    public BufferedImage getSprite(String name)
    {
      return(BufferedImage)getResource(name);
    }
}

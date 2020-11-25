package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.xml.stream.events.StartDocument;
public class SoundManager extends ResourceCache
{
  protected Object loadResource(URL url)
  {
    return Applet.newAudioClip(url);
  }
  
  public AudioClip getAudioClip(String name)
  {
    return(AudioClip)getResource(name);
  }
  
  public void playSong(final String name)
  {
    new Thread
     (
       new Runnable()
        {
          public void run()
          {
            getAudioClip(name).play();
          }
        }
      ).start();
  } 
}

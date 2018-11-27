package guInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sound {

   public static void main(String[] args) throws FileNotFoundException,
         JavaLayerException {

      Player apl = new Player(new FileInputStream(
            "raw/HaloSong.mp3"));

      apl.play();
   }
}
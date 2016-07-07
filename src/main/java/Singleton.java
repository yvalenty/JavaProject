import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    protected static void playMusic( ) throws IOException {
        try {

            File soundFile = new File("src/main/resources/background.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();


        } catch (IOException exc) {
            exc.printStackTrace();
        }

        catch (UnsupportedAudioFileException exc) {
            exc.printStackTrace();
        }

        catch (LineUnavailableException exc) {
            exc.printStackTrace();
        }
    }
}
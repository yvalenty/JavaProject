package com.gamemaschine;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    protected void playMusic() throws IOException {
        try {
            URL soundFile = this.getClass().getResource("/resources/background.wav");
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
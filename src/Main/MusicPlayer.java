package Main;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {
    private static Clip clip; // make clip static to share across instances

    public void play(String filePath) {
        stop(); // Stop any currently playing music

        try {
            File musicPath = new File(filePath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find the music file: " + filePath);
            }
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public void stop() {
        try {
            if (clip != null) {
                if (clip.isRunning()) clip.stop();
                clip.flush();
                clip.close();
                clip = null;
            }
        } catch (Exception e) {
            System.out.println("Error stopping music: " + e.getMessage());
        }
    }

    public void changeTrack(String filePath) {
        stop();
        play(filePath);
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}

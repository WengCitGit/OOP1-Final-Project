package Main;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer implements MusicPlayerInterface {
    private Clip clip;

    @Override
    public void play(String filePath) {
        new Thread(() -> {
            try {
                File audioFile = new File(filePath);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);

                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                }

                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY); // loop continuously
                clip.start();

                

            } catch (Exception e) {
                System.out.println("Error playing music: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }


    @Override
    public void stop() {
        if (clip != null) {
            if (clip.isRunning()) clip.stop();
            clip.close();
            clip = null;
        }
    }

    @Override
    public void changeTrack(String filePath) {
        stop();
        play(filePath);
    }

    @Override
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}

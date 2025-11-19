import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {
    private Clip clip;

    public void play(String filePath) {
        try {
            File musicPath = new File(filePath);

            if (musicPath.exists()) {
                // Create an AudioInputStream from the file
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                
                // Get a clip resource
                clip = AudioSystem.getClip();
                
                // Open the audio clip and load samples from the audio input stream
                clip.open(audioInput);
                
                // Start playing
                clip.start();
                
                // Loop continuously
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
            } else {
                System.out.println("Can't find the music file: " + filePath);
                System.out.println("Make sure 'bgm.wav' is in the project folder.");
            }
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public void stop() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.close(); // Close resources to free memory
        }
    }

    // Helper to check if music is currently active
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
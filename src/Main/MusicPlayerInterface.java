package Main;

public interface MusicPlayerInterface {
    void play(String filePath);
    void stop();
    void changeTrack(String filePath);
    boolean isPlaying();
}

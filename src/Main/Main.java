package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MusicPlayerInterface music = new MusicPlayer();

        
        if (!music.isPlaying()) {
            music.play("bgm.wav");
        }
        
        MainSubclass gameUI = new MainSubclass(scan, music);

        gameUI.startGameLoop();
    }
}

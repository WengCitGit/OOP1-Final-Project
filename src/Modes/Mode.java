package Modes;

import java.util.Scanner;
import Main.MusicPlayerInterface;
import Characters.Character;


public abstract class Mode {
    protected MusicPlayerInterface musicPlayer;
    protected static final String DEFAULT_BGM = "bgm.wav";
    protected Scanner scan = new Scanner(System.in);

    public Mode(MusicPlayerInterface music) {
        this.musicPlayer = music;
    }

    
    public abstract void start();

    public void displayGameOver(){
        System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);
    }

    // Helper: sleep
    protected void s(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    protected String getDisplayWithCharacterName(Character c, String playerLabel) {
        return playerLabel + " (" + c.getName() + ")";
    }
}

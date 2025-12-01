package Main;

import java.util.Scanner;
import Modes.*;

public class MainSubclass {
    private final Scanner scan;
    private final MusicPlayerInterface music;

    private final String EXIT_ASCII = """
                ######### ##     ##    ###    ##    ## ##    ##    ##    ##  #######  ##     ##    
                    ##    ##     ##   ## ##   ###   ## ##   ##      ##  ##  ##     ## ##     ##    
                    ##    ##     ##  ##   ##  ####  ## ##  ##        ####   ##     ## ##     ##    
                    ##    ######### ##     ## ## ## ## #####          ##    ##     ## ##     ##    
                    ##    ##     ## ######### ##  #### ##  ##         ##    ##     ## ##     ##    
                    ##    ##     ## ##     ## ##   ### ##   ##        ##    ##     ## ##     ##    
                    ##    ##     ## ##     ## ##    ## ##    ##       ##     #######   #######     

            ########  #######  ########     ########  ##          ###    ##    ## #### ##    ##  ######   
            ##       ##     ## ##     ##    ##     ## ##         ## ##    ##  ##   ##  ###   ## ##    ##  
            ##       ##     ## ##     ##    ##     ## ##        ##   ##    ####    ##  ####  ## ##        
            ######   ##     ## ########     ########  ##       ##     ##    ##     ##  ## ## ## ##   #### 
            ##       ##     ## ##   ##      ##        ##       #########    ##     ##  ##  #### ##    ##  
            ##       ##     ## ##    ##     ##        ##       ##     ##    ##     ##  ##   ### ##    ##  
            ##        #######  ##     ##    ##        ######## ##     ##    ##    #### ##    ##  ######  

                ███████╗ █████╗ ███████╗████████╗    ███████╗███████╗██╗   ██╗██████╗ ███████╗  ██║
                ██╔════╝██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██║   ██║██╔══██╗██╔════╝  ██║
                █████╗  ███████║███████╗   ██║       █████╗  █████╗  ██║   ██║██║  ██║███████╗  ██║
                ██╔══╝  ██╔══██║╚════██║   ██║       ██╔══╝  ██╔══╝  ██║   ██║██║  ██║╚════██║  ██║
                ██║     ██║  ██║███████║   ██║       ██║     ███████╗╚██████╔╝██████╔╝███████║  
                ╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝     ╚══════╝ ╚═════╝ ╚═════╝ ╚══════╝  ██║
        """;

    public MainSubclass(Scanner scan, MusicPlayerInterface music) {
        this.scan = scan;
        this.music = music;
    }

    public void startGameLoop() {
        boolean playAgain = true;

        while (playAgain) {
            displayTitle();
            waitForEnter();

            displayWelcomeMessage();

            int mode = chooseGameMode();

            // Handle info or exit
            if (mode == 5) {
                music.stop();
                music.play("arcade_bgm.wav");
                new GameInfo().displayGameInfo();
                continue;
            } else if (mode == 6) {
                exitGame();
            }

            startGameMode(mode);

            playAgain = askPlayAgain();
        }
    }


    public void displayTitle() {
        System.out.println();
        System.out.println("██████████████████████████████████████████████████████████████████████████████████████████╗");
        System.out.println("██╔═════════════════════════════════════════════════════════════════════════════════════██║");
        System.out.println("██║                                                                                     ██║");
        System.out.println("██║    ███████╗ █████╗ ███████╗████████╗    ███████╗███████╗██╗   ██╗██████╗ ███████╗   ██║");
        System.out.println("██║    ██╔════╝██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██║   ██║██╔══██╗██╔════╝   ██║");
        System.out.println("██║    █████╗  ███████║███████╗   ██║       █████╗  █████╗  ██║   ██║██║  ██║███████╗   ██║");
        System.out.println("██║    ██╔══╝  ██╔══██║╚════██║   ██║       ██╔══╝  ██╔══╝  ██║   ██║██║  ██║╚════██║   ██║");
        System.out.println("██║    ██║     ██║  ██║███████║   ██║       ██║     ███████╗╚██████╔╝██████╔╝███████║   ██║");
        System.out.println("██║    ╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝     ╚══════╝ ╚═════╝ ╚═════╝ ╚══════╝   ██║");
        System.out.println("██║                                                                                     ██║");
        System.out.println("██║            NOW SERVING: ZERO CALORIES, 100% DAMAGE!  A NOT-SO-HAPPY MEAL            ██║");
        System.out.println("██║                                                                                     ██║");
        System.out.println("██████████████████████████████████████████████████████████████████████████████████████████║");
        System.out.println("  ╚═══════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    public void displayWelcomeMessage() {
        System.out.println();
        System.out.println("     ************************************************************************");
        System.out.println("     **          Welcome to the Fast Feuds (Battle of the Mascots)         **");
        System.out.println("     **        a turn-based RPG-style game where restaurant mascots        **");
        System.out.println("     **      and special characters battle using food-themed attacks.      **");
        System.out.println("     ************************************************************************");
        System.out.println();
        System.out.println("Goal: Reduce your opponent's HP to 0 using strategy, skills, and combos.");
        System.out.println();
    }

    public int chooseGameMode() {
        int mode = 0;
        while (true) {
            try {
                System.out.println("Choose your gamemode:");
                System.out.println("===================================");
                System.out.println("*  [1] Player vs Player (PVP)     *");
                System.out.println("*  [2] Player vs Computer (PVC)   *");
                System.out.println("*  [3] Endless Mode               *");
                System.out.println("*  [4] Arcade Mode                *");
                System.out.println("*  [5] Game Info / Lore           *");
                System.out.println("*  [6] Exit Game                  *");
                System.out.println("===================================");
                System.out.print("Enter choice (1-6): ");
                mode = Integer.parseInt(scan.nextLine());

                if (mode >= 1 && mode <= 6) {
                    break;
                } else {
                    System.out.println("Invalid number! Please enter between 1 and 6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.\n");
            }
        }
        return mode;
    }

    private void startGameMode(int mode) {
        //GameMode game = new GameMode(this.music);
        Mode selectedMode;
        switch (mode) {
            case 1:
                System.out.println();
                System.out.println("████████████████████████████████████████████████████████████████ STARTING PVP MODE ████████████████████████████████████████████████████████████████ ");
                selectedMode = new PVPMode(this.music);
                selectedMode.start();
                break;
            case 2:
                System.out.println();
                System.out.println("████████████████████████████████████████████████████████████████ STARTING PVC MODE ████████████████████████████████████████████████████████████████ ");
                selectedMode = new PVCMode(this.music);
                selectedMode.start();
                break;
            case 3:
                System.out.println();
                System.out.println("███████████████████████████████████████████████████████████████ STARTING ENDLESS MODE ██████████████████████████████████████████████████████████████ ");
                music.stop();
                music.play("arcade_bgm.wav");
                selectedMode = new EndlessMode(this.music);
                selectedMode.start();
                music.stop();
                break;
            case 4:
                System.out.println("███████████████████████████████████████████████████████████████ STARTING ARCADE MODE ███████████████████████████████████████████████████████████████ ");
                music.stop();
                music.play("arcade_bgm.wav");
                selectedMode = new ArcadeMode(this.music);
                selectedMode.start();
                break;
            default:
                System.out.println("Invalid mode selected!");
        }
    }

    public boolean askPlayAgain() {
        while (true) {
            System.out.print("Would you like to play again? (y/n): ");
            if (!scan.hasNextLine()) {  
                return false;
            }
            String choice = scan.nextLine().trim().toLowerCase();

            if (choice.isEmpty()) {
                System.out.println("Please enter 'y' or 'n'.");
                continue;
            }

            char answer = choice.charAt(0);

            if (answer == 'y') {
                music.stop();
                music.play("bgm.wav");
                return true;
            } 
            else if (answer == 'n') {
                exitGame();
                return false; 
            } 
            else {
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
    }



    public void waitForEnter() {
        final boolean[] stopAnimation = {false};
        Thread animationThread = new Thread(() -> {
            String message = "Press ENTER to begin";
            int dots = 0;
            while (!stopAnimation[0]) {
                System.out.print("\r" + message + ".".repeat(dots) + "\033[K");
                dots = (dots + 1) % 4;
                try { Thread.sleep(500); } catch (InterruptedException e) { break; }
            }
        });
        animationThread.start();
        scan.nextLine();
        stopAnimation[0] = true;
        animationThread.interrupt();
        try { animationThread.join(); } catch (InterruptedException e) {}
    }

    public void exitGame() {
        System.out.println(EXIT_ASCII);
        System.out.println("\nSee you next time!\n");
        music.stop();
        System.exit(0);
    }
}

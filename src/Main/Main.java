package Main;
import java.util.Scanner;

public class Main {
    private static final String EXIT_ASCII = """
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

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);
        MusicPlayer music = new MusicPlayer();
        music.play("bgm.wav");
        

        while (playAgain) {
            displayTitle();
            waitForEnterWithAnimation(scan);

            displayWelcomeMessage();

            int mode = chooseGameMode(scan);

            GameInfo gameInfo = new GameInfo();

            // Handle info or exit (moved to options 5 and 6)
            if (mode == 5) {
                music.stop();
                music.play("arcade_bgm.wav");
                gameInfo.displayGameInfo();
                continue;
            } else if (mode == 6) {
                exitGame(music, scan);
            }

            
            startGameMode(mode, music);

            // Play again prompt
            playAgain = askPlayAgain(scan, music);
        }

        scan.close();
    }

    private static void displayTitle() {
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

    private static void displayWelcomeMessage() {
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

    private static int chooseGameMode(Scanner scan) {
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

    private static void startGameMode(int mode, MusicPlayer music) {
        GameMode game = new GameMode(music);

        switch (mode) {
            case 1:
                System.out.println();
                System.out.println("████████████████████████████████████████████████████████████████ STARTING PVP MODE ████████████████████████████████████████████████████████████████ ");
                game.startPVP();
                break;
            case 2:
                System.out.println();
                System.out.println("████████████████████████████████████████████████████████████████ STARTING PVC MODE ████████████████████████████████████████████████████████████████ ");
                game.startPVC();
                break;
            case 3:
                System.out.println();
                System.out.println("███████████████████████████████████████████████████████████████ STARTING ENDLESS MODE ███████████████████████████████████████████████████████████████ ");
                music.stop();
                music.play("arcade_bgm.wav");
                game.startEndless();
                music.stop();
                break;
            case 4:
                System.out.println("███████████████████████████████████████████████████████████████ STARTING ARCADE MODE ███████████████████████████████████████████████████████████████ ");
                music.stop();
                music.play("arcade_bgm.wav");
                game.startArcadeMode();
                break;
            default:
                System.out.println("Invalid mode selected!");
        }
    }

    private static boolean askPlayAgain(Scanner scan, MusicPlayer music) {
        while (true) {
            System.out.print("Would you like to play again? (y/n): ");
            String choice = scan.nextLine().trim().toLowerCase();
            if (choice.isEmpty()) continue;

            char answer = choice.charAt(0);
            if (answer == 'y') {
                music.stop();
                music.play("bgm.wav");
                return true;
            } else if (answer == 'n') {
                exitGame(music, scan);
            } else {
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
    }

    private static void exitGame(MusicPlayer music, Scanner scan) {
        System.out.println(EXIT_ASCII);
        System.out.println("\nSee you next time!\n");
        music.stop();
        scan.close();
        System.exit(0);
    }

    public static void waitForEnterWithAnimation(Scanner scan) {
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
}

package Main;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);

        //music player
        MusicPlayer music = new MusicPlayer();

        while(playAgain){

            if (!music.isPlaying()) {
                music.play("bgm.wav");
            }
            

            System.out.println("██████████████████████████████████████████████████████████████████████████████████╗");
            System.out.println("██╔═════════════════════════════════════════════════════════════════════════════██║");
            System.out.println("██║                                                                             ██║");
            System.out.println("██║    ███████╗ █████╗ ███████╗████████╗    ███████╗███████╗██╗   ██╗██████╗    ██║");
            System.out.println("██║    ██╔════╝██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██║   ██║██╔══██╗   ██║");
            System.out.println("██║    █████╗  ███████║███████╗   ██║       █████╗  █████╗  ██║   ██║██║  ██║   ██║");
            System.out.println("██║    ██╔══╝  ██╔══██║╚════██║   ██║       ██╔══╝  ██╔══╝  ██║   ██║██║  ██║   ██║");
            System.out.println("██║    ██║     ██║  ██║███████║   ██║       ██║     ███████╗╚██████╔╝██████╔╝   ██║");
            System.out.println("██║    ╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝     ╚══════╝ ╚═════╝ ╚═════╝    ██║");
            System.out.println("██║                                                                             ██║");
            System.out.println("██████████████████████████████████████████████████████████████████████████████████║");
            System.out.println("  ╚═══════════════════════════════════════════════════════════════════════════════╝");

            System.out.println();
            waitForEnterWithAnimation(scan);
            System.out.println();

            System.out.println("     ************************************************************************");
            System.out.println("     ************************************************************************");
            System.out.println("     **                                                                    **");
            System.out.println("     **              Welcome to the Battle of the Mascots,                 **");
            System.out.println("     **        a turn-based RPG-style game where restaurant mascots        **");
            System.out.println("     **      and special characters battle using food-themed attacks.      **");
            System.out.println("     **                                                                    **");
            System.out.println("     ************************************************************************");
            System.out.println("     ************************************************************************");
            System.out.println();
            System.out.println();
            System.out.println("Goal: Reduce your opponent's HP to 0 using strategy, skills, and combos.");
            System.out.println();
            System.out.println();


            //choose gamemode
            int mode = 0;
            boolean isEnabledMode = true;

            while(isEnabledMode) {
                try {
                    System.out.println("      Choose your gamemode:");
                    System.out.println("===================================");
                    System.out.println("*  [1] Player vs Player (PVP)     *");
                    System.out.println("*  [2] Player vs Computer (PVC)   *");
                    System.out.println("*  [3] Endless Mode               *");
                    System.out.println("*  [4] Arcade Mode (Coming Soon)  *");
                    System.out.println("*  [5] Game Info / Lore           *");
                    System.out.println("*  [6] Exit Game                  *");
                    System.out.println("===================================");
                    System.out.print("Enter choice (1-6): ");
                    mode = Integer.parseInt(scan.nextLine());

                    if (mode >= 1 && mode <= 6) {
                        isEnabledMode = false;
                    } else {
                        System.out.println();
                        System.out.println("Invalid number! Please enter between 1 and 6.");
                        System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Invalid input! Numbers only.");
                    System.out.println();
                }
                
            }


            GameInfo gameInfo = new GameInfo();

            // Handle choice
            if (mode == 5) {
                gameInfo.displayGameInfo();
                continue;
            } else if (mode == 6) {
                System.out.println("Exiting game. Thanks for playing!");
                // --- STOP MUSIC ON EXIT ---
                music.stop();
                scan.close();
                return;
            }

            System.out.println();
            
            System.out.print("You chose Option " + mode + ".");
            switch (mode) {
                case 1 : System.out.println(" Player vs Player Mode.");
                    break;
                case 2 : System.out.println(" Player vs Computer Mode.");                  
                    break;
                case 3 : System.out.println(" Endless Mode.");
                    break;
                case 4 : System.out.println(" Arcade Mode (Coming Soon).");
                    break;
                case 5 : gameInfo.displayGameInfo();
                    break;
                case 6 :
                    System.out.println(" Exiting game. Thanks for playing!");
                    music.stop();
                    scan.close();
                    return;
                default : System.out.println(" Invalid mode.");
            }

            System.out.println();

            //START GAME
            GameMode game = new GameMode();
            switch(mode) {
                case 1:
                    System.out.println("--------------------Starting PVP MODE--------------------");
                    game.startPVP();  // start PVP mode
                    break;
                case 2:
                    System.out.println("--------------------Starting PVC MODE--------------------");
                    game.startPVC();  // start Player vs Computer
                    break;
                case 3:
                    System.out.println("--------------------Starting ENDLESS MODE--------------------");
                    music.stop();
                    music.play("arcade_bgm.wav");
                    game.startEndless();  // start Endless Mode
                    music.stop();  
                    break;
                case 4:
                    System.out.println("--------------------Arcade Mode (Coming Soon)--------------------");
                    game.startArcadeModePlaceholder();
                    break;
                default:
                    System.out.println("Invalid mode selected!");
            }

            // --- ASK TO PLAY AGAIN ---

            while (true) {
                try {
                    System.out.println();
                    System.out.print("Would you like to play again? (y/n): ");
                    String choice = scan.nextLine().trim().toLowerCase();

                    
                    if (choice.isEmpty()) {
                        System.out.println("Please enter 'y' or 'n'.");
                        continue; 
                    }

                    char answer = choice.charAt(0);

                    if (answer == 'y') {
                        playAgain = true;
                    } else if (answer == 'n') {
                        playAgain = false;
                        System.out.println("\nThanks for playing Battle of the Mascots! See you next time!\n");
                        music.stop();
                    } else {
                        System.out.println("Invalid input! Please enter 'y' or 'n'.");
                        continue; 
                    }

                    System.out.println();
                    break; 
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    playAgain = false;
                    music.stop();
                    break; 
                }
            }

        }   
            scan.close();


    }

    public static void waitForEnterWithAnimation(Scanner scan) {
        final boolean[] stopAnimation = {false};

        Thread animationThread = new Thread(() -> {
            String message = "Press ENTER to begin";
            int dots = 0;

            while (!stopAnimation[0]) {
                String dotString = ".".repeat(dots);
                
                // \033[K clears line to the right
                System.out.print("\r" + message + dotString + "\033[K"); 

                dots = (dots + 1) % 4; // Cycle 0, 1, 2, 3

                try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    break;
                }
            }
            
        });

        animationThread.start();
        scan.nextLine();
        stopAnimation[0] = true;
        animationThread.interrupt(); 
        try { animationThread.join(); } catch (InterruptedException e) {}
    }
}



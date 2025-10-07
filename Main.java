
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

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
        System.out.print("Press ENTER to begin...");
        scan.nextLine();
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
        System.out.println("Goal: Reduce your opponent’s HP to 0 using strategy, skills, and combos.");
        System.out.println();
        System.out.println();


        //choose gamemode
        int mode = 0;
        boolean isEnabledMode = true;

        while(isEnabledMode) {
            try {
                System.out.println("Choose your gamemode:");
                System.out.println("==================================");
                System.out.println("*  1. Player vs Player (PVP)     *");
                System.out.println("*  2. Player vs Computer (PVC)   *");
                System.out.println("*  3. Arcade Mode                *");
                System.out.println("==================================");
                System.out.print("Enter choice (1-3): ");
                mode = Integer.parseInt(scan.nextLine());

                if (mode >= 1 && mode <= 3) {
                    isEnabledMode = false;
                } else {
                    System.out.println();
                    System.out.println("Invalid number! Please enter between 1 and 3.");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Error: " + e.getMessage());
                System.out.println("Invalid input! Numbers only.");
                System.out.println();
            }
            
        }

        System.out.println();
        System.out.print("You choose " + mode + ".");
        switch (mode) {
            case 1 : System.out.println(" Player vs Player Mode.");
                break;
            case 2 : System.out.println(" Player vs Computer Mode.");                  
                break;
            case 3 : System.out.println(" Arcade Mode.");
                break;
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
                System.out.println("--------------------Starting ARCADE MODE--------------------");
                game.startArcade();  // start Arcade Mode
                break;
            default:
                System.out.println("Invalid mode selected!");
        }

        scan.close();

    }
}
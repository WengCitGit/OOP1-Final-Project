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
        System.out.println("     Goal: Reduce your opponent’s HP to 0 using strategy, skills, and combos.");
        System.out.println();
        System.out.println();


        //choose gamemode
        int mode;
        while(true) {
            System.out.println("Choose your gamemode:");
            System.out.println("==================================");
            System.out.println("*  1. Player vs Player (PVP)     *");
            System.out.println("*  2. Player vs Computer (PVC)   *");
            System.out.println("*  3. Arcade Mode                *");
            System.out.println("==================================");
            System.out.print("Enter choice (1-3): ");


            if (scan.hasNextInt()) {
                mode = scan.nextInt();

                if (mode >= 1 && mode <= 3) {
                    break;
                } else {
                    System.out.println();
                    System.out.println("Invalid number! Please enter between 1 and 3.");
                    System.out.println();
                }
            } else {
                System.out.println();
                System.out.println("Invalid input! Numbers only.");
                System.out.println();
                scan.next();
            }
        }

        System.out.println();
        System.out.println("You choose mode " + mode + ".");
        System.out.println();
        System.out.println("Choose your gamemode:");
        System.out.println("1. Player vs Player (PVP)");
        System.out.println("2. Player vs Computer (PVC)");
        System.out.println("3. Arcade Mode");


    }
}

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("██████████████████████████████████████████████████████████████████████████████████╗");
        System.out.println("██╔═════════════════════════════════════════════════════════════════════════════██║");
        System.out.println("██║                                                                             ██║");
        System.out.println("██║                                                                             ██║");
        System.out.println("██║    ███████╗ █████╗ ███████╗████████╗    ███████╗███████╗██╗   ██╗██████╗    ██║");
        System.out.println("██║    ██╔════╝██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██║   ██║██╔══██╗   ██║");
        System.out.println("██║    █████╗  ███████║███████╗   ██║       █████╗  █████╗  ██║   ██║██║  ██║   ██║");
        System.out.println("██║    ██╔══╝  ██╔══██║╚════██║   ██║       ██╔══╝  ██╔══╝  ██║   ██║██║  ██║   ██║");
        System.out.println("██║    ██║     ██║  ██║███████║   ██║       ██║     ███████╗╚██████╔╝██████╔╝   ██║");
        System.out.println("██║    ╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝     ╚══════╝ ╚═════╝ ╚═════╝    ██║");
        System.out.println("██║                                                                             ██║");
        System.out.println("██║                                                                             ██║");
        System.out.println("██████████████████████████████████████████████████████████████████████████████████║");
        System.out.println("  ╚═══════════════════════════════════════════════════════════════════════════════╝");
       
        System.out.println();
        System.out.println("Press ENTER to begin...");
        sc.nextLine();
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
        System.out.println();

        //choose gamemode
        System.out.println("Choose your gamemode:");
        System.out.println("1. Player vs Player (PVP)");
        System.out.println("2. Player vs Computer (PVC)");
        System.out.println("3. Arcade Mode");
        System.out.print("Enter choice (1-3): ");
        int mode = scan.nextInt();
        scan.nextLine();

        System.out.println();
        System.out.println("You choose  mode " + mode + ".");
        System.out.println();

        //choose characters
        System.out.println("Choose Your Character:");
        System.out.println("1. Jollibee - Crispy Joy Bringer");
        System.out.println("2. McDo - Big Mac Basher");
        System.out.println("3. KFC - Colonel’s Drumstick Duelist");
        System.out.println("4. Burger King - Flame Griller");
        System.out.println("5. Wendy’s - Sassy Red Fighter");
        System.out.println("6. Jack in the Box - Trickster Clown");
        System.out.println("7. Little Caesars - Pizza Gladiator");
        System.out.println("8. Chief Khai (Kuya Guard) - Whistle Warrior");
        System.out.print("Enter choice (1-8): ");
        int character = scan.nextInt();
        scan.nextLine();

        System.out.println();
        System.out.print("Enter gamemode (1 - 3): ");
        int gameMode = scan.nextInt();


    }
}

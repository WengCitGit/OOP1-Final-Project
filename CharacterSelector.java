
import characters.*; 
import java.util.Scanner;

public class CharacterSelector {
    private Scanner scan = new Scanner(System.in);

    public characters.Character chooseCharacter() {
        int choice = 0;
        System.out.println("=================================================*");
        System.out.println("*  1. Jollibee - Crispy Joy Bringer              *");
        System.out.println("*  2. McDo - Big Mac Basher                      *");
        System.out.println("*  3. KFC - Colonel's Drumstick Duelist          *");
        System.out.println("*  4. Burger King - Flame Griller                *");
        System.out.println("*  5. Wendy's - Sassy Red Fighter                *");
        System.out.println("*  6. Jack in the Box - Trickster Clown          *");
        System.out.println("*  7. Little Caesars - Pizza Gladiator           *");
        System.out.println("*  8. Chief Khai - Whistle Warrior               *");
        System.out.println("==================================================");
       
        while (true) {
            System.out.print("Enter choice (1-8): ");

            try {
                String input = scan.nextLine(); // Read the entire line
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= 8) break;

                System.out.println("Invalid number! Please enter 1–8.\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.\n");
            }
        }

        System.out.println();
        System.out.println("You chose character " + choice + ".");
        System.out.println();

        switch (choice) {
            case 1 -> { return new Jollibee(); }
            case 2 -> { return new McDonalds(); }
            case 3 -> { return new KFC(); }
            case 4 -> { return new BurgerKing(); }
            case 5 -> { return new Wendys(); }
            case 6 -> { return new JackInTheBox(); }
            case 7 -> { return new LittleCaesars(); }
            case 8 -> { return new ChiefKhai(); }
            default -> { return new Jollibee(); }
        }
    
    }

    public characters.Character chooseRandomCharacter() {
        int choice = 1 + (int)(Math.random() * 8); // Random number between 1 and 8

        switch (choice) {
            case 1 -> { return new Jollibee(); }
            case 2 -> { return new McDonalds(); }
            case 3 -> { return new KFC(); }
            case 4 -> { return new BurgerKing(); }
            case 5 -> { return new Wendys(); }
            case 6 -> { return new JackInTheBox(); }
            case 7 -> { return new LittleCaesars(); }
            case 8 -> { return new ChiefKhai(); }
            default -> { return new Jollibee(); }
        }
    }

    
}

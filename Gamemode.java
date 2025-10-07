import characters.*; 
import java.util.Scanner;
import battle.Battle; // Replace 'your.package' with the actual package name where Battle.java is located

public class GameMode {

    public void startPVP(){
        CharacterSelector selector = new CharacterSelector();

        System.out.println("\nPlayer 1, choose your character:");
        characters.Character player1 = selector.chooseCharacter();

        System.out.println("\nPlayer 2, choose your character:");
        characters.Character player2 = selector.chooseCharacter();

        Battle battle = new Battle(player1, player2);
        battle.start();
    }

        public void startPVC() {
        System.out.println("\n--- PLAYER VS COMPUTER MODE ---");

        CharacterSelector selector = new CharacterSelector();
        characters.Character player1 = selector.chooseCharacter();

        characters.Character enemy = new McDonalds(); // or randomize later

        Battle battle = new Battle(player1, enemy);
        battle.start();
    }

    public void startArcade() {
        System.out.println("\n--- ARCADE MODE ---");
        System.out.println("Coming soon! Fight random mascots in a survival streak!");
    }
}

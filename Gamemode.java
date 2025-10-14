import characters.*; 
import java.util.*;
import battle.Battle; 

public class GameMode {

    public void startPVP(){
        CharacterSelector selector = new CharacterSelector();

        System.out.println("\nPlayer 1, choose your character:");
        characters.Character player1 = selector.chooseCharacter();

        System.out.println("\nPlayer 2, choose your character:");
        characters.Character player2 = selector.chooseCharacter();

        System.out.println("##########################################################################################");
        System.out.println("       Player 1: " + player1.getName() + " VS Player 2: " + player2.getName());
        System.out.println("##########################################################################################");

        Battle battle = new Battle(player1, player2);
        battle.start();
    }

        public void startPVC() {
        System.out.println("\n--- PLAYER VS COMPUTER MODE ---");

        CharacterSelector selector = new CharacterSelector();
        characters.Character player1 = selector.chooseCharacter();

        characters.Character enemy = selector.chooseRandomCharacter(); // or randomize later

        System.out.println("#####################################################################");
        System.out.println("       Player 1: " + player1.getName() + " VS Computer: " + enemy.getName());
        System.out.println("#####################################################################");

        Battle battle = new Battle(player1, enemy);
        battle.start();
    }

    public void startArcade() {
        System.out.println("\n--- ARCADE MODE ---");
        System.out.println("Coming soon! Fight random mascots in a survival streak!");
    }
}

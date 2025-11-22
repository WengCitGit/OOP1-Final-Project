package Main;
import java.util.*;
import Battle.*;
import Characters.*; 

    public class GameMode {

        public void startPVP(){
            CharacterSelector selector = new CharacterSelector();

            System.out.println("\nPlayer 1, choose your character:");
            Characters.Character player1 = selector.chooseCharacter();

            System.out.println("\nPlayer 2, choose your character:");
            Characters.Character player2 = selector.chooseCharacter();

            System.out.println("##########################################################################################");
            System.out.println("       Player 1: " + player1.getName() + " VS Player 2: " + player2.getName());
            System.out.println("##########################################################################################");

            Battle battle = new Battle(player1, player2);
            battle.start();
        }

        public void startPVC() {
            System.out.println("\n--- PLAYER VS COMPUTER MODE ---");

            CharacterSelector selector = new CharacterSelector();
            Characters.Character player1 = selector.chooseCharacter();
            Characters.Character enemy = selector.chooseRandomCharacter();

            System.out.println("##########################################################################################");
            System.out.println("       Player 1: " + player1.getName() + " VS Computer: " + enemy.getName());
            System.out.println("##########################################################################################");

            Battle battle = new Battle(player1, enemy, true); 
            battle.start();
        }


        public void startArcade() {
            System.out.println("\n--- ARCADE MODE ---");
            System.out.println("Coming soon! Fight random mascots in a survival streak!");
            System.out.println("Deathmatch against random characters until you lose!");
            System.out.println("Defeat as many as you can!");
            System.out.println("Replace the boss with your own character!");
           
        }
    }

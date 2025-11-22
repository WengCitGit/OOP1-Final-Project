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
            System.out.println("Deathmatch against random characters until you lose!");
            System.out.println("Defeat as many as you can!");
            System.out.println();

            CharacterSelector selector = new CharacterSelector();

            System.out.println("Choose your champion for Arcade Mode:");
            Characters.Character player = selector.chooseCharacter();

            int streak = 0;
            while (true) {
                System.out.println();
                System.out.println("===== ARCADE ROUND " + (streak + 1) + " =====");
                Characters.Character enemy = selector.chooseRandomCharacter();

                System.out.println("Matchup: " + player.getName() + " VS " + enemy.getName());
                System.out.println("Get ready...");

                // Use PVC-style Battle so enemy acts automatically
                Battle battle = new Battle(player, enemy, true);
                battle.start();

                // After battle, Battle.start() leaves the Character objects with their final HP state.
                if (player.isAlive()) {
                    // Player won the match
                    streak++;
                    // Heal player by 60% of max HP (capped)
                    player.healPercentage(0.6);

                    System.out.println("\nYou defeated " + enemy.getName() + "!");
                    System.out.println("Current streak: " + streak);
                    System.out.println("Your HP: " + player.getHealth() + " / " + player.getMaxHealth());
                    System.out.println("\nPress ENTER to face the next challenger...");
                    // wait for ENTER (simple console pause)
                    try { System.in.read(); } catch (Exception e) { /* ignore */ }
                    continue;
                } else {
                    // Player lost
                    System.out.println("\nYou were defeated by " + enemy.getName() + "!");
                    System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                    break;
                }
            }
        }
    }

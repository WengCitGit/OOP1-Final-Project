package Main;
import java.util.*;
import Battle.*;
import Characters.*; 

    public class GameMode {
    private Scanner scan = new Scanner(System.in);

        public void startPVP(){
                CharacterSelector selector = new CharacterSelector();

                System.out.print("\nEnter name for Player 1: ");
                String player1Name = scan.nextLine().trim();
                if (player1Name.isEmpty()) player1Name = "Player 1";

                System.out.println("\n" + player1Name + ", choose your character:");
                Characters.Character player1 = selector.chooseCharacter();

                System.out.print("\nEnter name for Player 2: ");
                String player2Name = scan.nextLine().trim();
                if (player2Name.isEmpty()) player2Name = "Player 2";

                System.out.println("\n" + player2Name + ", choose your character:");
                Characters.Character player2 = selector.chooseCharacter();

                System.out.println("##########################################################################################");
                System.out.println("       " + player1Name + ": " + player1.getName() + " VS " + player2Name + ": " + player2.getName());
                System.out.println("##########################################################################################");

                Battle battle = new Battle(player1, player2, player1Name, player2Name);
                battle.start();
        }

        public void startPVC() {
            System.out.println("\n--- PLAYER VS COMPUTER MODE ---");
            CharacterSelector selector = new CharacterSelector();

            System.out.print("\nEnter your name: ");
            String playerName = scan.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player 1";

            System.out.println();
            System.out.println(playerName + ", choose your character:");
            Characters.Character player1 = selector.chooseCharacter();
            Characters.Character enemy = selector.chooseRandomCharacter();

            System.out.println("##########################################################################################");
            System.out.println("       " + playerName + ": " + player1.getName() + " VS Computer: " + enemy.getName());
            System.out.println("##########################################################################################");

            Battle battle = new Battle(player1, enemy, true, playerName, "Computer"); 
            battle.start();
        }

        public void startEndless() {
            System.out.println("\n--- ENDLESS MODE ---");
            System.out.println("Deathmatch against random characters until you lose!");
            System.out.println("Defeat as many as you can!");
            System.out.println();

            CharacterSelector selector = new CharacterSelector();

            System.out.print("\nEnter your name for Endless Mode: ");
            String playerName = scan.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player";

            System.out.println("Choose your champion for Endless Mode, " + playerName + ":");
            Characters.Character player = selector.chooseCharacter();

            int streak = 0;
            while (true) {
                System.out.println();
                System.out.println("===== ENDLESS ROUND " + (streak + 1) + " =====");
                Characters.Character enemy = selector.chooseRandomCharacter();

                System.out.println("Matchup: " + playerName + ": " + player.getName() + " VS " + enemy.getName());
                System.out.println("Get ready...");

                // Use PVC-style Battle so enemy acts automatically
                Battle battle = new Battle(player, enemy, true, playerName, "Computer");
                battle.start();

                // After battle, Battle.start() leaves the Character objects with their final HP state.
                if (player.isAlive()) {
                    // Player won the match
                    streak++;
                    // Heal player to full HP after each battle
                    player.restoreHP();

                    System.out.println("\nYou defeated " + enemy.getName() + "!");
                    System.out.println("Current streak: " + streak);
                    System.out.println("Your HP: " + player.getHealth() + " / " + player.getMaxHealth());
                    System.out.println("\nPress ENTER to face the next challenger...");
                    // wait for ENTER (simple console pause)
                    try { System.in.read(); } catch (Exception e) { /* ignore */ }
                    continue;
                } else {
                    // Player lost
                    System.out.println("\n" + playerName + " was defeated by " + enemy.getName() + "!");
                    System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                    break;
                }
            }
        }

        // Placeholder for expanded Arcade Mode (option 4 in menu)
        public void startArcadeModePlaceholder() {
            System.out.println();
            System.out.println("Arcade Mode is coming soon!\nThis slot will host a separate Arcade experience.");
            System.out.println("Press ENTER to return to the main menu...");
            try { System.in.read(); } catch (Exception e) { /* ignore */ }
        }
    }

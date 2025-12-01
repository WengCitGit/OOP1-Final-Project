package Modes;

import Battle.Battle;
import Main.CharacterSelector;
import Main.MusicPlayerInterface;
import Characters.Character;

public class EndlessMode extends Mode {

    public EndlessMode(MusicPlayerInterface music) {
        super(music);
    }

    @Override
    public void start() {
        System.out.println();
        System.out.println("Deathmatch against random characters until you lose!");
        System.out.println("Defeat as many as you can!");
        System.out.println();

        CharacterSelector selector = new CharacterSelector();

        System.out.print("\nEnter your name for Endless Mode: ");
        String playerName = scan.nextLine().trim();
        if (playerName.isEmpty()) playerName = "Player";

        System.out.println("Choose your champion for Endless Mode, " + playerName + ":");
        Character player = selector.chooseCharacter();

        int streak = 0;
        while (true) {
            System.out.println();

            Character enemy;
            do {
                enemy = selector.chooseRandomCharacter();
            } while (enemy.getName().equals(player.getName()));

            // Display player and enemy names using helper method
            displayStreakBanner(streak); 
            System.out.println("Matchup:");
            System.out.println(getDisplayWithCharacterName(player, playerName) + " VS " +
                                getDisplayWithCharacterName(enemy, "Enemy"));

            System.out.println("Get ready...");

            // Use PVC-style Battle so enemy acts automatically
            Battle battle = new Battle(player, enemy, true, playerName, "Computer");
            battle.start();

            if (player.isAlive()) {
                streak++;
                player.restoreHP();

                System.out.println("\nYou defeated " + enemy.getName() + "!");
                System.out.println("Current streak: " + streak);
                System.out.println("Your HP: " + player.getHealth() + " / " + player.getMaxHealth());

                while (true) {
                    System.out.print("\nPress ENTER to face the next challenger, or type 's' then ENTER to surrender: ");
                    String next = scan.nextLine();

                    if (next == null || next.trim().isEmpty()) break;

                    if (next.trim().equalsIgnoreCase("s")) {
                        while (true) {
                            System.out.print("Are you sure you want to surrender? (y/n): ");
                            String confirm = scan.nextLine().trim();
                            if (confirm.equalsIgnoreCase("y")) {
                                System.out.println("\nYou surrendered!");
                                System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                                return;
                            } else if (confirm.equalsIgnoreCase("n")) break;
                            else System.out.println("Please answer 'y' or 'n'.");
                        }
                    } else break;
                }

                continue;
            } else {
                System.out.println("\n" + playerName + " was defeated by " + enemy.getName() + "!");
                System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                break;
            }
        }

        displayGameOver();
    }

    private void displayStreakBanner(int streak){
        System.out.println();
        System.out.println("                                      ============================================================================");
        System.out.println("                                                               ENDLESS MODE - STREAK: " + streak + "            ");
        System.out.println("                                      ============================================================================");
        System.out.println();
    }
}

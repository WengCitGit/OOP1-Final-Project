package battle;

import java.util.Random;
import java.util.Scanner;
import characters.Character;

public class Battle {
    private Character player1;
    private Character player2;
    private boolean isPVC;
    private Random random = new Random();


    public Battle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isPVC = false;
    }

    public Battle(Character player1, Character enemy, boolean isPVC) {
        this.player1 = player1;
        this.player2 = enemy;
        this.isPVC = isPVC;
    }

public void start() {
    Scanner scanner = new Scanner(System.in);
    int round = 1;
    int player1Wins = 0;
    int player2Wins = 0;

    while (round <= 3 && player1Wins < 2 && player2Wins < 2) {

        // Reset HP and Mana at the start of each round
        player1.restoreHP();
        player2.restoreHP();
        player1.restoreMana();
        player2.restoreMana();

        System.out.println("\n                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ROUND " + round + " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");

        int turn = 1;
        boolean player1Starts = random.nextBoolean();
        System.out.println("First Turn: " + (player1Starts ? player1.getName() : player2.getName()));

        // Single round battle
        // Single round battle
        while (player1.isAlive() && player2.isAlive()) {
            Character current, opponent;

            if ((turn % 2 != 0 && player1Starts) || (turn % 2 == 0 && !player1Starts)) {
                current = player1;
                opponent = player2;
            } else {
                current = player2;
                opponent = player1;
            }

            System.out.println("\n══════════ ROUND " + round + " - TURN " + turn + " ══════════");
            System.out.println(current.getName() + "'s Turn!");
            showStats();

            int move = (isPVC && current == player2) ? random.nextInt(3) + 1 : chooseMove(scanner, current);
            performMoveWithBanner(current, opponent, move);

            // Random mana regen every 2 turns
            if (turn % 2 == 0 && random.nextBoolean()) {
                player1.regenerateMana();
                player2.regenerateMana();
                System.out.println("\n Both players regenerated some mana!");
            }

            turn++;
        }


        // Round end
        if (player1.isAlive()) {
            player1Wins++;
            System.out.println("\nROUND " + round + " WINNER: " + player1.getName());
        } else if (player2.isAlive()) {
            player2Wins++;
            System.out.println("\nROUND " + round + " WINNER: " + player2.getName());
        } else {
            System.out.println("\nROUND " + round + " IS A DRAW!");
        }

        System.out.println("Score: " + player1.getName() + " " + player1Wins + " - " + player2Wins + " " + player2.getName());
        
        // Only go to next round if no one has 2 wins yet
        if (player1Wins == 2 || player2Wins == 2) break;

        round++;
    }

    // Match winner
    System.out.println("\n──────────────────────── MATCH END ────────────────────────");
    if (player1Wins > player2Wins) {
        System.out.println("OVERALL WINNER: " + player1.getName() + "!");
    } else {
        System.out.println("OVERALL WINNER: " + player2.getName() + "!");
    }
}


    private int chooseMove(Scanner scanner, Character player) {
        System.out.println("Choose a move:");
        System.out.println();

        System.out.println("[1] Basic Attack - " + player.getBasicSkillName());
        System.out.println("     Mana Cost: " + player.getBasicManaCost() +
                        " | Damage: " + player.getBasicMinDmg() + "-" + player.getBasicMaxDmg());

        System.out.println("[2] Secondary Skill - " + player.getSecondarySkillName());
        System.out.println("     Mana Cost: " + player.getSecondaryManaCost() +
                        " | Damage: " + player.getSecondaryMinDmg() + "-" + player.getSecondaryMaxDmg());

        System.out.println("[3] Ultimate Skill - " + player.getUltimateSkillName());
        System.out.println("     Mana Cost: " + player.getUltimateManaCost() +
                        " | Damage: " + player.getUltimateMinDmg() + "-" + player.getUltimateMaxDmg());

        System.out.println();
        System.out.print("Enter your choice: ");

        
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); 
            choice = 1;
        }
        System.out.println();
        return choice;
        
    }

    private void performMoveWithBanner(Character attacker, Character defender, int move) {
        int beforeHP = defender.getHealth();
        String moveBannerName;

        switch (move) {
            case 1:
                moveBannerName = attacker.getBasicSkillName();
                attacker.basicAttack(defender);
                break;
            case 2:
                moveBannerName = attacker.getSecondarySkillName();
                attacker.secondarySkill(defender);
                break;
            case 3:
                moveBannerName = attacker.getUltimateSkillName();
                attacker.ultimateSkill(defender);
                break;
            default:
                moveBannerName = attacker.getBasicSkillName();;
                attacker.basicAttack(defender);
                break;
        }

        int damage = Math.max(0, beforeHP - defender.getHealth());

        System.out.println();
        System.out.println("^ " + attacker.getName() + " used " + moveBannerName + "!");
        if (damage > 0) {
            System.out.println("^ " + defender.getName() + " took " + damage + " damage!");
        } else {
            System.out.println("^ " + defender.getName() + " dodged the attack!");
        }
        System.out.println("");
    }

    private void showStats() {
        System.out.println("\n******************--- STATUS ---*********************");
        System.out.println(player1.getName() + ": HP " + player1.getHealth() + "/" + player1.getMaxHealth() +
                " | Mana " + player1.getCurrentMana() + "/" + player1.getMaxMana());
        System.out.println(player2.getName() + ": HP " + player2.getHealth() + "/" + player2.getMaxHealth() +
                " | Mana " + player2.getCurrentMana() + "/" + player2.getMaxMana());
        System.out.println("*****************************************************");
    }
}

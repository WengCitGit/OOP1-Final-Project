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
        int turn = 1;

        // randomize who goes first
        boolean player1Starts = random.nextBoolean();

        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("                  BATTLE START!");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println(" Player 1: " + player1.getName() + "  VS  Player 2: " + player2.getName());
        System.out.println(" First Turn: " + (player1Starts ? player1.getName() : player2.getName()));
        System.out.println("══════════════════════════════════════════════════");

        // main battle loop
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n============================");
            System.out.println(" TURN " + turn);
            System.out.println("============================");

            Character current, opponent;

            // determine turn order: alternate between player1 and player2
            if ((turn % 2 != 0 && player1Starts) || (turn % 2 == 0 && !player1Starts)) {
                current = player1;
                opponent = player2;
            } else {
                current = player2;
                opponent = player1;
            }

            System.out.println("\n" + current.getName() + "'s Turn!");
            showStats();

            int move;
            if (isPVC && current == player2) {
                move = random.nextInt(3) + 1;
                System.out.println("Computer chose move #" + move + "!");
            } else {
                move = chooseMove(scanner, current);
            }

            performMoveWithBanner(current, opponent, move);

            // Random mana regen every 2 turns
            if (turn % 2 == 0 && random.nextBoolean()) {
                player1.regenerateMana();
                player2.regenerateMana();
                System.out.println("\n Both players regenerated some mana!");
            }

            showStats();
            turn++;
        }

        // end of battle
        System.out.println("\n══════════════════════════════════════════════════");
        if (player1.isAlive()) {
            System.out.println(" PLAYER 1 (" + player1.getName() + ") WINS!");
        } else {
            System.out.println(" PLAYER 2 (" + player2.getName() + ") WINS!");
        }
        System.out.println("══════════════════════════════════════════════════");
    }

    private int chooseMove(Scanner scanner, Character player) {
        System.out.println("Choose a move:");
        System.out.println("[1] Basic Attack");
        System.out.println("[2] Secondary Skill");
        System.out.println("[3] Ultimate Skill");
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); 
            choice = 1;
        }
        return choice;
    }

    private void performMoveWithBanner(Character attacker, Character defender, int move) {
        int beforeHP = defender.getHealth();
        String moveName;

        switch (move) {
            case 1:
                moveName = "Basic Attack";
                attacker.basicAttack(defender);
                break;
            case 2:
                moveName = "Secondary Skill";
                attacker.secondarySkill(defender);
                break;
            case 3:
                moveName = "Ultimate Skill";
                attacker.ultimateSkill(defender);
                break;
            default:
                moveName = "Basic Attack";
                attacker.basicAttack(defender);
                break;
        }

        int damage = Math.max(0, beforeHP - defender.getHealth());

        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println(" " + attacker.getName() + " used " + moveName + "!");
        if (damage > 0) {
            System.out.println(" " + defender.getName() + " took " + damage + " damage!");
        } else {
            System.out.println(" " + defender.getName() + " dodged the attack!");
        }
        System.out.println("══════════════════════════════════════════════════");
    }

    private void showStats() {
        System.out.println("\n******************--- STATUS ---******************");
        System.out.println(player1.getName() + ": HP " + player1.getHealth() + "/" + player1.getMaxHealth() +
                " | Mana " + player1.getCurrentMana() + "/" + player1.getMaxMana());
        System.out.println(player2.getName() + ": HP " + player2.getHealth() + "/" + player2.getMaxHealth() +
                " | Mana " + player2.getCurrentMana() + "/" + player2.getMaxMana());
        System.out.println("*****************************************************");
    }
}

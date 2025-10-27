package battle;

import characters.Character;
import java.util.Scanner;

public class Battle {
    private Character player1, player2;
    private Scanner scan = new Scanner(System.in);

    public Battle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println(" Battle Start! ");
        System.out.println(player1.getName() + " vs " + player2.getName());
        System.out.println("----------------------------------");

        // Battle loop
        while (player1.isAlive() && player2.isAlive()) {
            playerTurn(player1, player2);
            if (!player2.isAlive()) break;

            playerTurn(player2, player1);
        }

        System.out.println("----------------------------------");
        if (player1.isAlive()) {
            System.out.println( player1.getName() + " wins the battle!");
        } else {
            System.out.println(player2.getName() + " wins the battle!");
        }
    }

    private void playerTurn(Character attacker, Character defender) {
        System.out.println(attacker.getName() + "'s turn!");
        System.out.println("Choose an action:");
        System.out.println("1. Basic Attack");
        System.out.println("2. Secondary Skill");
        System.out.println("3. Ultimate Skill");

        int choice;
        while (true) {
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice >= 1 && choice <= 3) break;
                System.out.println(" Invalid choice! Try again.");
            } catch (Exception e) {
                System.out.println(" Please enter a number!");
            }
        }

        switch (choice) {
            case 1:
                attacker.basicAttack(defender);
                break;
            case 2:
                attacker.secondarySkill(defender);
                break;
            case 3:
                attacker.ultimateSkill(defender);
                break;
        }

        System.out.println(defender.getName() + " HP: " + defender.getHealth());
        System.out.println(attacker.getName() + " HP: " + attacker.getHealth());
    }
}

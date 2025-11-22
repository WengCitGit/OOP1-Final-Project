package Battle;
import java.util.Scanner;
import Characters.Character;

public class Player {
    private String name;
    private Character character;
    private boolean isHuman;
    private Scanner scan = new Scanner(System.in);

    public Player(String name, Character character, boolean isHuman) {
        this.name = name;
        this.character = character;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public boolean isDefeated() {
        return character.getHealth() <= 0;
    }

    public void takeTurn(Character opponent) {
        System.out.println("\n--- " + name + "'s Turn ---");
        int move = isHuman ? chooseMove() : aiMove();
        performMove(move, opponent);
    }

    private int chooseMove() {
        System.out.println("Choose your move:");
        System.out.println("1. Basic Attack");
        System.out.println("2. Secondary Skill");
        System.out.println("3. Ultimate Skill");
        System.out.print("Enter choice: ");
        return scan.nextInt();
    }

    private int aiMove() {
        return (int)(Math.random() * 3) + 1; // random between 1 and 3
    }

    private void performMove(int move, Character opponent) {
        switch (move) {
            case 1 -> character.basicAttack(opponent);
            case 2 -> character.secondarySkill(opponent);
            case 3 -> character.ultimateSkill(opponent);
            default -> System.out.println("Invalid move! Turn skipped.");
        }
    }
}

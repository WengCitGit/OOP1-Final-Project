package battle;

import characters.Character;

public class Enemy extends Player {

    public Enemy(String name, Character character) {
        super(name, character, false); // false = not human
    }

    @Override
    public void takeTurn(Character opponent) {
        System.out.println("\n--- " + getName() + "'s Turn (AI) ---");
        int move = aiMove();
        performMove(move, opponent);
    }

    private int aiMove() {
        double r = Math.random();
        if (r < 0.5) return 1; // 50% Basic
        else if (r < 0.8) return 2; // 30% Secondary
        else return 3; // 20% Ultimate
    }

    private void performMove(int move, Character opponent) {
        switch (move) {
            case 1 -> getCharacter().basicAttack(opponent);
            case 2 -> getCharacter().secondarySkill(opponent);
            case 3 -> getCharacter().ultimateSkill(opponent);
        }
    }
}

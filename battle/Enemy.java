package characters;

public class Enemy extends Character {

    @Override
    public void takeTurn(Character opponent) {
        System.out.println(getName() + "'s turn!");

        
        int choice = 1 + (int)(Math.random() * 3);

        switch (choice) {
            case 1 -> {
                System.out.println(getName() + " used Basic Attack!");
                basicAttack(opponent);
            }
            case 2 -> {
                System.out.println(getName() + " used Secondary Skill!");
                secondarySkill(opponent);
            }
            case 3 -> {
                System.out.println(getName() + " used Ultimate Skill!");
                ultimateSkill(opponent);
            }
        }

        System.out.println(opponent.getName() + " HP: " + opponent.getHealth());
        System.out.println(getName() + " HP: " + getHealth());
        System.out.println();
    }
}

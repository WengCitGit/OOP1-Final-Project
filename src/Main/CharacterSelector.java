package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Characters.*;

public class CharacterSelector {
    private Scanner scan = new Scanner(System.in);

    private final String[] names = {

            "Jollibee - Crispy Joy Bringer ",
            "McDonald's - Big Mac Basher",
            "KFC - Colonel's Drumstick Duelist",
            "Burger King - Flame Griller",
            "Wendy's - Sassy Red Fighter",
            "Jack in the Box - Trickster Clown",
            "Little Caesars - Pizza Gladiator",
            "Chief Khai - Whistle Warrior"

    };

    public Characters.Character[] getAllCharacters() {
        Characters.Character[] chars = {
            new Jollibee(),
            new McDonalds(),
            new KFC(),
            new BurgerKing(),
            new Wendys(),
            new JackInTheBox(),
            new LittleCaesars(),
            new ChiefKhai()
        };

        // Set proper names (with your titles)
        for (int i = 0; i < chars.length; i++) {
            chars[i].setName(names[i]);
        }
        return chars;
    }


    public Characters.Character chooseCharacter() {
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("*  1. Jollibee - Crispy Joy Bringer              *");
        System.out.println("*  2. McDonald's - Big Mac Basher                *");
        System.out.println("*  3. KFC - Colonel's Drumstick Duelist          *");
        System.out.println("*  4. Burger King - Flame Griller                *");
        System.out.println("*  5. Wendy's - Sassy Red Fighter                *");
        System.out.println("*  6. Jack in the Box - Trickster Clown          *");
        System.out.println("*  7. Little Caesars - Pizza Gladiator           *");
        System.out.println("*  8. Chief Khai - Whistle Warrior               *");
        System.out.println("==================================================");
        
        while (true) {
            System.out.print("Enter choice (1-8): ");

            try {
                String input = scan.nextLine(); // Read the entire line
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= 8) break;

                System.out.println("Invalid number! Please enter 1–8.\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.\n");
            }
        }

        System.out.println();
        System.out.println("You chose character " + choice + ". " + names[choice - 1] + ".");
        

        Characters.Character chosen = createCharacter(choice);
        chosen.setName(names[choice - 1]);
        return chosen;

    
    }

    public Characters.Character chooseRandomCharacter() {

        int choice = 1 + (int)(Math.random() * 8); // Random number between 1 and 8

        System.out.println();
        System.out.println("Computer has selected character " + choice + ". " + names[choice - 1] + ".");
        System.out.println();

        Characters.Character chosen = createCharacter(choice);
        chosen.setName(names[choice - 1]); // ✅ update name to include title
        return chosen;

    }

    private Characters.Character createCharacter(int choice){
        
        switch (choice) {
            case 1 -> { return new Jollibee(); }
            case 2 -> { return new McDonalds(); }
            case 3 -> { return new KFC(); }
            case 4 -> { return new BurgerKing(); }
            case 5 -> { return new Wendys(); }
            case 6 -> { return new JackInTheBox(); }
            case 7 -> { return new LittleCaesars(); }
            case 8 -> { return new ChiefKhai(); }
            default -> { return new Jollibee(); }
        }
    }

    public Characters.Character getCharacterByName(String name) {
        Characters.Character[] list = getAllCharacters();

        for (int i = 0; i < list.length; i++) {

            // Exact match (full title, trimmed)
            if (list[i].getName().trim().equalsIgnoreCase(name.trim())) {
                return list[i];
            }

            // Match just the first word (e.g., "Jollibee")
            String shortName = list[i].getName().split(" - ")[0];

            if (shortName.equalsIgnoreCase(name)) {
                return list[i];
            }
        }

        return null;
    }


    
    public Characters.Character getDevBoss(String name) {
        return new Characters.Character(
            name,           // name
            375,           // maxHp
            70,            // maxMana
            8,             // regenMana
            "Dev Strike",   // basicSkillName
            "Dev Blast",    // secondarySkillName
            "Dev Ultimate", // ultimateSkillName
            10, 15, 30,        // mana costs
            5, 8,         // basic min/max damage
            7, 12,        // secondary min/max damage
            12, 15        // ultimate min/max damage
        ) {
            @Override
            public void basicAttack(Characters.Character target) {
                performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), getBasicSkillName());
            }

            @Override
            public void secondarySkill(Characters.Character target) {
                performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), getSecondarySkillName());
            }

            @Override
            public void ultimateSkill(Characters.Character target) {
                performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), getUltimateSkillName());
            }
        };
    }

    public Characters.Character chooseRandomCharacterExcluding(Characters.Character exclude) {
        Characters.Character[] all = getAllCharacters();
        List<Characters.Character> filtered = new ArrayList<>();

        for (Characters.Character c : all) {
            if (c != null && !c.getName().equalsIgnoreCase(exclude.getName())) {
                filtered.add(c);
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("No characters available to choose from!");
            return null;
        }

        int choice = (int) (Math.random() * filtered.size());
        Characters.Character chosen = filtered.get(choice);

        System.out.println();
        System.out.println("Computer has selected character: " + chosen.getName() + ".");
        System.out.println();

        return chosen;
    }

}



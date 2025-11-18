package characters;

public class JackInTheBox extends Character {

    public JackInTheBox() {
        super(
            "Jack In The Box",
            165,       // Max HP
            60,        // Max Mana
            2,         // Mana Regen

            // Skill names
            "Giant Headbutt Express",
            "Drive-Thru Confusion",
            "Titanic Jumbo Jack Combo",

            // Mana Costs
            0,    // Basic
            20,   // Secondary
            35,   // Ultimate

            // Damage values
            11, 16,   // Basic min/max dmg
            15, 24,   // Secondary min/max dmg
            24, 60    // Ultimate min/max dmg
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target,
            getBasicMinDmg(), getBasicMaxDmg(),
            getBasicManaCost(),
            "Giant Headbutt Express"
        );
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target,
            getSecondaryMinDmg(), getSecondaryMaxDmg(),
            getSecondaryManaCost(),
            "Drive-Thru Confusion"
        );
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target,
            getUltimateMinDmg(), getUltimateMaxDmg(),
            getUltimateManaCost(),
            "Titanic Jumbo Jack Combo"
        );
    }
}

package characters;

public class LittleCaesars extends Character {

    public LittleCaesars() {
        super(
            "Little Caesars",
            185,   // Max HP
            55,    // Max Mana
            4,     // Mana Regen
            "Hot-N-Ready Slam",
            "Crazy Bread Barrage",
            "Deep! Deep! Dish Catastrophe",

            // Mana Costs
            0,     // Basic
            15,    // Secondary
            25,    // Ultimate

            // Damage Ranges
            12, 18,   // Basic min/max
            18, 26,   // Secondary min/max
            30, 45    // Ultimate min/max
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Hot-N-Ready Slam");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Crazy Bread Barrage");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Deep! Deep! Dish Catastrophe");
    }
}

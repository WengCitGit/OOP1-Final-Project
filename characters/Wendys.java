package characters;

public class Wendys extends Character {

    public Wendys() {
        super(
            "Wendys",
            165,   // Max HP
            60,    // Max Mana
            4,     // Mana Regen
            "Sassy Roast",
            "Vanilla Vengeance",
            "Order Blocker",

            // Mana Costs
            0,     // Basic
            14,    // Secondary
            35,    // Ultimate

            // Damage Ranges
            10, 15,   // Basic min/max
            16, 25,   // Secondary min/max
            15, 25    // Ultimate min/max
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Sassy Roast");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Vanilla Vengeance");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Order Blocker");
    }
}

package Characters;
public class KFC extends Character {

    public KFC() {
        super(
            "Kentucky Fried Chicken",
            165,   // Max HP
            55,    // Max Mana
            3,     // Mana Regen
            "DrumStick Smash",
            "Shooting Flaming Hotshot",
            "Secret Sauce Overload",

            // Mana Costs
            0,     // Basic
            20,    // Secondary
            30,    // Ultimate

            // Damage Ranges
            13, 17,   // Basic min/max
            22, 28,   // Secondary min/max
            30, 40    // Ultimate min/max
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "DrumStick Smash");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Shooting Flaming Hotshot");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Secret Sauce Overload");
    }
}

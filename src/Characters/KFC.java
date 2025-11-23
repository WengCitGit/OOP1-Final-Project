package Characters;
public class KFC extends Character {

    public KFC() {
        super(
            "Kentucky Fried Chicken",
            165,   // max HP
            55,    // max Mana
            5,     // mana regen

            // SKILL NAMES
            "DrumStick Smash",
            "Shooting Flaming Hotshot",
            "Secret Sauce Overload",

            // MANA COSTS
            0,     // basic mana cost
            20,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            13, 17,   // basic min-max dmg
            18, 25,   // secondary min-max dmg
            28, 42    // ultimate min-max dmg
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

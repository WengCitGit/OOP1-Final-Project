package Characters;
public class KFC extends Character {

    public KFC() {
        super(
            "Kentucky Fried Chicken",
            165,   // max HP
            60,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "DrumStick Smash",
            "Hotshot Burst",
            "Secret Sauce Overload",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            12, 17,   // basic min-max dmg
            20, 30,   // secondary min-max dmg
            32, 50    // ultimate min-max dmg
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

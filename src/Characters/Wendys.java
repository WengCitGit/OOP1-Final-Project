package Characters;
public class Wendys extends Character {

    public Wendys() {
        super(
            "Wendys",
            165,   // max HP
            55,    // max Mana
            6,     // mana regen

            // SKILL NAMES
            "Sassy Roast",
            "Vanilla Vengeance",
            "Order Blocker",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            12, 17,   // basic min-max dmg
            21, 31,   // secondary min-max dmg
            30, 48    // ultimate min-max dmg
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

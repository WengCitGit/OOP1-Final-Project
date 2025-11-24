package Characters;
public class Wendys extends Character {

    public Wendys() {
        super(
            "Wendys",
            165,   // max HP
            55,    // max Mana
            8,     // mana regen

            // SKILL NAMES
            "Sassy Roast",
            "Vanilla Vengeance",
            "Order Blocker",

            // MANA COSTS
            0,     // basic mana cost
            12,    // secondary mana cost
            26,    // ultimate mana cost

            // DAMAGE VALUES
            11, 15,   // basic min-max dmg
            17, 35,   // secondary min-max dmg
            33, 43    // ultimate min-max dmg
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

package Characters;
public class Wendys extends Character {

    public Wendys() {
        super(
            "Wendys",
            165,   // max HP
            60,    // max Mana
            8,     // mana regen

            // SKILL NAMES
            "Sassy Roast",
            "Vanilla Vengeance",
            "Order Blocker",

            // MANA COSTS
            0,     // basic mana cost
            14,    // secondary mana cost
            35,    // ultimate mana cost

            // DAMAGE VALUES
            10, 15,   // basic min-max dmg
            16, 22,   // secondary min-max dmg
            25, 40    // ultimate min-max dmg
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

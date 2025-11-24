package Characters;
public class Jollibee extends Character {

    public Jollibee() {
        super(
            "Jollibee",
            165,   // max HP
            55,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "Juicylicious Crispy Chicken Joy Slam",
            "Langhap Sarap Aura",
            "Super Meal Combo Domination",

            // MANA COSTS
            0,     // basic mana cost
            13,    // secondary mana cost
            27,    // ultimate mana cost

            // DAMAGE VALUES
            13, 17,   // basic min-max dmg
            19, 37,   // secondary min-max dmg
            35, 45      // ultimate min-max dmg
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Juicylicious Crispy Chicken Joy Slam");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Langhap Sarap Aura");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Super Meal Combo Domination");
    }
}

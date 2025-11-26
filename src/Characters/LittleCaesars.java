package Characters;
public class LittleCaesars extends Character {

    public LittleCaesars() {
        super(
            "Little Caesars",
            165,   // max HP
            55,    // max Mana
            6,     // mana regen

            // SKILL NAMES
            "Hot-N-Ready Slam",
            "Crazy Bread Barrage",
            "Deep! Deep! Dish Catastrophe",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            28,    // ultimate mana cost

            // DAMAGE VALUES
            12, 17,   // basic min-max dmg
            20, 30,   // secondary min-max dmg
            34, 42    // ultimate min-max dmg
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

package Characters;
public class LittleCaesars extends Character {

    public LittleCaesars() {
        super(
            "Little Caesars",
            170,   // max HP
            55,    // max Mana
            5,     // mana regen

            // SKILL NAMES
            "Hot-N-Ready Slam",
            "Crazy Bread Barrage",
            "Deep! Deep! Dish Catastrophe",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            25,    // ultimate mana cost

            // DAMAGE VALUES
            12, 14,   // basic min-max dmg
            16, 24,   // secondary min-max dmg
            30, 45    // ultimate min-max dmg
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

package Characters;
public class BurgerKing extends Character {

    public BurgerKing() {
        super(
            "Burger King",
            160,   // max HP
            60,    // max Mana
            5,     // mana regen

            // SKILL NAMES
            "Whopper Flame",
            "Onion Ring Shockwave",
            "Flame-Grilled Feast",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            25,    // ultimate mana cost

            // DAMAGE VALUES
            5, 10,     // basic min-max dmg
            9, 12,     // secondary min-max dmg
            20, 35     // ultimate min-max dmg
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(
            target,
            getBasicMinDmg(),
            getBasicMaxDmg(),
            getBasicManaCost(),
            getBasicSkillName()
        );
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(
            target,
            getSecondaryMinDmg(),
            getSecondaryMaxDmg(),
            getSecondaryManaCost(),
            getSecondarySkillName()
        );
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(
            target,
            getUltimateMinDmg(),
            getUltimateMaxDmg(),
            getUltimateManaCost(),
            getUltimateSkillName()
        );
    }
}

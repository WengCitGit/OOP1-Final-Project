package Characters;
public class McDonalds extends Character {

    public McDonalds() {
        super(
            "McDonald's",
            160,   // max HP
            60,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "McFlurry Blast",
            "BFF Fries Fury",
            "BIG MAC Slam",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            11, 16,   // basic min-max dmg
            19, 29, // secondary min-max dmg
            34, 52    // ultimate min-max dmg
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Frosty McFlurry Blast");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Crispy BFF Fries Fury");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Colossal BIG MAC Slam");
    }
}

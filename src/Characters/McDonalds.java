package Characters;
public class McDonalds extends Character {

    public McDonalds() {
        super(
            "McDonald's",
            160,   // max HP
            60,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "Frosty McFlurry Blast",
            "Crispy BFF Fries Fury",
            "Colossal BIG MAC Slam",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            12, 17,   // basic min-max dmg
            21, 31, // secondary min-max dmg
            32, 50    // ultimate min-max dmg
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

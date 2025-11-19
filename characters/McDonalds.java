package characters;

public class McDonalds extends Character {

    public McDonalds() {
        super(
            "McDonalds",
            165,   // Max HP
            55,    // Max Mana
            15,    // Mana Regen
            "Frosty McFlurry Blast",
            "Crispy BFF Fries Fury",
            "Colossal BIG MAC Slam",

            // Mana Costs
            0,     // Basic
            15,    // Secondary
            25,    // Ultimate

            // Damage Ranges
            10, 15,   // Basic min/max
            15, 22,   // Secondary min/max
            25, 58    // Ultimate min/max
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

package characters;

public class Jollibee extends Character {

    public Jollibee() {
        super(
            "Jollibee",
            150,   // Max HP
            60,    // Max Mana
            15,    // Mana Regen
            "Juicylicious Crispy Chicken Joy Slam",
            "Langhap Sarap Aura",
            "Super Meal Combo Domination",
            
            // Mana Costs
            0,     // Basic
            12,    // Secondary
            25,    // Ultimate
            
            // Damage Ranges
            10, 16,    // Basic min/max
            14, 20,    // Secondary min/max
            24, 55     // Ultimate min/max
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

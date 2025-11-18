package characters;

public class ChiefKhai extends Character {

    public ChiefKhai() {
        super(
            "Chief Khai",
            200,      // Max HP
            75,       // Max Mana
            2,        // Mana Regen
            "Batuta Bonk",
            "Pakibukas ng bag",
            "Mega Whistle Shockwave",
            
            // Mana Costs
            0,   // Basic
            15,  // Secondary
            32,  // Ultimate

            // Damage values
            12, 20,   // Basic min/max dmg
            16, 30,   // Secondary min/max dmg
            30, 65    // Ultimate min/max dmg
        );
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Batuta Bonk");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Pakibukas ng bag");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Mega Whistle Shockwave");
    }
}

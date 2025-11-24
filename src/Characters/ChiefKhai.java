package Characters;
public class ChiefKhai extends Character {

    public ChiefKhai() {
        super(
            "Chief Khai",
            170,   // max HP
            55,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "Batuta Bonk",
            "Pakibukas ng Bag",
            "Mega Whistle Shockwave",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            32,    // ultimate mana cost

            // DAMAGE VALUES
            12, 14,   // basic min-max dmg
            18, 28,   // secondary min-max dmg
            35, 55    // ultimate min-max dmg
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


    public ChiefKhai(boolean arcadeOP) {
        super(
            "Chief Khai",
            180,      // Max HP (insanely high)
            85,       // Max Mana
            12,        // Mana Regen
            "OP Strike",
            "OP Kick",
            "OP Ultimate",
            
            // Mana Costs
            0,   // Basic
            18,   // Secondary
            45,   // Ultimate

            // Damage values
            10, 23,   // Basic min/max dmg
            26, 32,   // Secondary min/max dmg
            27, 58   // Ultimate min/max dmg
        );
    }

}

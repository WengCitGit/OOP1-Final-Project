package Characters;
public class ChiefKhai extends Character {

    public ChiefKhai() {
        super(
            "Chief Khai",
            180,   // max HP
            70,    // max Mana
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
            12, 16,   // basic min-max dmg
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
            500,      // Max HP (insanely high)
            160,       // Max Mana
            50,        // Mana Regen
            "OP Strike",
            "OP Kick",
            "OP Ultimate",
            
            // Mana Costs
            0,   // Basic
            0,   // Secondary
            0,   // Ultimate

            // Damage values
            200, 300,   // Basic min/max dmg
            30, 60,   // Secondary min/max dmg
            40, 65   // Ultimate min/max dmg
        );
    }

}

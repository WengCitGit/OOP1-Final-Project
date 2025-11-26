package Characters;
public class JackInTheBox extends Character {

    public JackInTheBox() {
        super(
            "Jack In The Box",
            160,   // max HP
            60,    // max Mana
            7,     // mana regen

            // SKILL NAMES
            "Giant Headbutt Express",
            "Drive-Thru Confusion",
            "Titanic Jumbo Jack Combo",

            // MANA COSTS
            0,     // basic mana cost
            15,    // secondary mana cost
            30,    // ultimate mana cost

            // DAMAGE VALUES
            11, 16,   // basic min-max dmg
            19, 29,   // secondary min-max dmg
            32, 50    // ultimate min-max dmg
        );
    }


    @Override
    public void basicAttack(Character target) {
        performAttack(target, getBasicMinDmg(), getBasicMaxDmg(), getBasicManaCost(), "Giant Headbutt Express");
    }

    @Override
    public void secondarySkill(Character target) {
        performAttack(target, getSecondaryMinDmg(), getSecondaryMaxDmg(), getSecondaryManaCost(), "Drive-Thru Confusion");
    }

    @Override
    public void ultimateSkill(Character target) {
        performAttack(target, getUltimateMinDmg(), getUltimateMaxDmg(), getUltimateManaCost(), "Titanic Jumbo Jack Combo");
    }
}

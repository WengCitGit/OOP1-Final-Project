package characters;
public class ChiefKhai extends Character{

    public ChiefKhai() 
    {
        super("Chief Khai", 200, 75, 0); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 12, 20, 0, "Batuta Bonk"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 16, 30, 15, "Pakibukas ng bag"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 30, 65, 28, "Mega Whistle Shockwave"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

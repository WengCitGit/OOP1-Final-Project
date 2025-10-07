public class KFC extends Character{
    public KFC() 
    {
        super("Kentucky Fried Chicken", 120, 80, 15); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 10, 15, 0, "basic"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 20, 25, 20, "skill"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 40, 50, 50, "ult"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

public class Wendys extends Character{
    public Wendys() 
    {
        super("Wendys", 175, 65, 0); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 10, 15, 0, "Sassy Roast"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 16, 25, 14, "Vanilla Vengeance"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 15, 25, 50, "Order Blocker"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

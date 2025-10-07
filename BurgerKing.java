public class BurgerKing extends Character{
    public BurgerKing() 
    {
        super("Burger King", 165, 60, 3); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 5, 10, 0, "Whopper Flame"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 9, 12, 15, "Onion Ring Shockwave "); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 20, 35, 25, "Flame-Grilled Feast"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

package characters;
public class LittleCaesars extends Character{
    public LittleCaesars() 
    {
        super("Little Caesars", 185, 55, 0, "Hot-N-Ready Slam", "Crazy Bread Barrage", "Deep! Deep! Dish Catastrophe"); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 12, 18, 0, "Hot-N-Ready Slam"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 18, 26, 15, "Crazy Bread Barrage"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 30, 62, 25, "Deep! Deep! Dish Catastrophe"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

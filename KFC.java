public class KFC extends Character{
    public KFC() 
    {
        super("Kentucky Fried Chicken", 155, 60, 3); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 13, 17, 0, "DrumStick Smash"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 22, 28, 20, "Shooting Flaming Hotshot"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 30, 40, 45, "Secret Sauce Overload"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

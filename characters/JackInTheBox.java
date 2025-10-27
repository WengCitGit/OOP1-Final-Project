package characters;
public class JackInTheBox extends Character{
    public JackInTheBox() 
    {
        super("Jack In The Box", 165, 60, 0, "Giant Headbutt Express", "Drive-Thru Confusion", "Titanic Jumbo Jack Combo"); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 11, 16, 0, "Giant Headbutt Express"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 15, 24, 20, "Drive-Thru Confusion"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 24, 60, 50, "Titanic Jumbo Jack Combo"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

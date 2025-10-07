package characters;
public class Jollibee extends Character{
    public Jollibee() 
    {
        super("Jollibee", 150, 60, 15); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 10, 16, 0, "Juicylicious Crispy Chicken Joy Slam"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 14, 20, 12, "Langhap Sarap Aura"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 24, 55, 25, "Super Meal Combo Domination"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

public class McDonalds extends Character{
    public McDonalds() 
    {
        super("McDonalds", 160, 55, 15); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) 
    {
        performAttack(target, 10, 15, 0, "Frosty McFlurry Blast"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void secondarySkill(Character target) 
    {
        performAttack(target, 15, 22, 15, "Crispy BFF Fries Fury"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateSkill(Character target) 
    {
        performAttack(target, 25, 58, 25, "Colossal BIG MAC Slam"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

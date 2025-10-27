package characters;

import java.util.Random;

public abstract class Character {

    // ====== Attributes ======
    private String name;
    private int hp;
    private int maxHp;
    private int currMana;
    private int maxMana;
    private int regenMana;
    private Random random;

    // Skill names
    private String basicSkillName;
    private String secondarySkillName;
    private String ultimateSkillName;

    // ====== Constructor ======
    public Character(String name, int maxHp, int maxMana, int regenMana,
                     String basicSkillName, String secondarySkillName, String ultimateSkillName) {

        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMana = maxMana;
        this.currMana = maxMana;
        this.regenMana = regenMana;
        this.random = new Random();

        this.basicSkillName = basicSkillName;
        this.secondarySkillName = secondarySkillName;
        this.ultimateSkillName = ultimateSkillName;
    }

    // ====== Core Battle Mechanics ======
    protected void performAttack(Character target, int minDamage, int maxDamage, int manaCost, String skillName) {
        if (this.currMana < manaCost) {
            System.out.println(this.name + " does not have enough mana for " + skillName +
                               "! (Needs " + manaCost + ", has " + this.currMana + ")");
            return;
        }

        this.currMana -= manaCost;
        int damage = minDamage + this.random.nextInt(maxDamage - minDamage + 1);
        target.takeDamage(damage);

        System.out.println("══════════════════════════════════════════════════");
        System.out.println(this.name + " used " + skillName + "!");
        System.out.println(this.name + " deals " + damage + " damage to " + target.getName() + "!");
        System.out.println("══════════════════════════════════════════════════");
    }

    // ====== Abstract Skill Methods ======
    public abstract void basicAttack(Character target);
    public abstract void secondarySkill(Character target);
    public abstract void ultimateSkill(Character target);

    // ====== Health and Mana Mechanics ======
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void regenerateMana() {
        this.currMana = Math.min(this.maxMana, this.currMana + this.regenMana);
    }

    public void regenerateManaRandomly() {
        // Example: random regen between 5 and regenMana after 2 turns (handled in Battle)
        int regen = 5 + random.nextInt(this.regenMana);
        this.currMana = Math.min(this.maxMana, this.currMana + regen);
    }

    // ====== Getters ======
    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.hp;
    }

    public int getMaxHealth() {
        return this.maxHp;
    }

    public int getCurrentMana() {
        return this.currMana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public String getBasicSkillName() {
        return this.basicSkillName;
    }

    public String getSecondarySkillName() {
        return this.secondarySkillName;
    }

    public String getUltimateSkillName() {
        return this.ultimateSkillName;
    }

    // ====== Setters ======
    public void setName(String name) {
        this.name = name;
    }
}

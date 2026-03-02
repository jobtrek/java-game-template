package ch.jobtrek.game.characters;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name) {
        super(name, 80, 20, 5, 8);
        this.maxMana = 50;
        this.mana = maxMana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > maxMana) {
            this.mana = maxMana;
        } else {
            this.mana = mana;
        }
    }

    @Override
    public void executeAttack(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " casts a magic bolt on " + target.getName());
    }

    @Override
    public void useSpecialAbility(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " casts Fireball on " + target.getName());
    }

    @Override
    public String describeActions() {
        return "1. Magic Bolt\n2. Fireball";
    }

    @Override
    public String toString() {
        return "Mage " + super.toString() + " [MANA: " + mana + "/" + maxMana + "]";
    }
}

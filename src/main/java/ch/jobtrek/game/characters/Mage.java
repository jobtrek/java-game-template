package ch.jobtrek.game.characters;

import ch.jobtrek.game.rules.CombatRules;

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
    public void onTurnStart() {
        int regen = 10;
        setMana(getMana() + regen);
        System.out.println(getName() + " regenerates " + regen + " mana.");
    }

    @Override
    public void executeAttack(Character target) {
        int manaCost = 10;
        int damage;
        if (getMana() >= manaCost) {
            setMana(getMana() - manaCost);
            damage = CombatRules.calculateDamage(getPower(), 1.0, target.getDefense());
            damage = CombatRules.applyDamageVariance(damage);
            System.out.println(getName() + " casts Magic Bolt on " + target.getName() + " for " + damage + " damage! (Costs " + manaCost + " mana)");
        } else {
            damage = CombatRules.calculateDamage(getPower(), 0.5, target.getDefense());
            damage = CombatRules.applyDamageVariance(damage);
            System.out.println(getName() + " is out of mana! Performing basic magic strike for " + damage + " damage.");
        }
        target.takeDamage(damage);
    }

    @Override
    public void useSpecialAbility(Character target) {
        int manaCost = 30;
        if (getMana() >= manaCost) {
            setMana(getMana() - manaCost);
            int damage = CombatRules.calculateDamage(getPower(), 2.0, target.getDefense());
            damage = CombatRules.applyDamageVariance(damage);
            System.out.println(getName() + " casts Fireball on " + target.getName() + " for " + damage + " damage! (Costs " + manaCost + " mana)");
            target.takeDamage(damage);
        } else {
            System.out.println(getName() + " doesn't have enough mana for Fireball!");
            executeAttack(target);
        }
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

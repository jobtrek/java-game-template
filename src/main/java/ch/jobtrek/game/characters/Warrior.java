package ch.jobtrek.game.characters;

import ch.jobtrek.game.rules.CombatRules;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 120, 15, 12, 6);
    }

    @Override
    public void executeAttack(Character target) {
        int damage = CombatRules.calculateDamage(getPower(), 1.0, target.getDefense());
        damage = CombatRules.applyDamageVariance(damage);
        System.out.println(getName() + " strikes " + target.getName() + " with a sword for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void useSpecialAbility(Character target) {
        int damage = CombatRules.calculateDamage(getPower(), 2.0, target.getDefense());
        damage = CombatRules.applyDamageVariance(damage);
        int selfDamage = 10;
        System.out.println(getName() + " uses Power Strike on " + target.getName() + " for " + damage + " damage, but exhausts itself for " + selfDamage + " HP!");
        target.takeDamage(damage);
        this.takeDamage(selfDamage);
    }

    @Override
    public String describeActions() {
        return "1. Sword Slash\n2. Power Strike";
    }

    @Override
    public String toString() {
        return "Warrior " + super.toString();
    }
}

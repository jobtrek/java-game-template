package ch.jobtrek.game.characters;

import ch.jobtrek.game.rules.CombatRules;

public class Rogue extends Character {
    private int energy;
    private int maxEnergy;

    public Rogue(String name) {
        super(name, 90, 13, 7, 14);
        this.maxEnergy = 100;
        this.energy = maxEnergy;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.clamp(energy, 0, maxEnergy);
    }

    @Override
    public void onTurnStart() {
        int regen = 15;
        setEnergy(getEnergy() + regen);
        System.out.println(getName() + " regenerates " + regen + " energy.");
    }

    @Override
    public void executeAttack(Character target) {
        double modifier = 1.0;
        if (this.getSpeed() > target.getSpeed()) {
            modifier = 1.2;
            System.out.print("(Speed bonus! x1.2) ");
        }
        int damage = CombatRules.calculateDamage(getPower(), modifier, target.getDefense());
        damage = CombatRules.applyDamageVariance(damage);
        System.out.println(getName() + " performs a quick slash on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void useSpecialAbility(Character target) {
        int energyCost = 40;
        if (getEnergy() >= energyCost) {
            setEnergy(getEnergy() - energyCost);
            int damage = CombatRules.calculateDamage(getPower(), 2.5, target.getDefense());
            damage = CombatRules.applyDamageVariance(damage);
            System.out.println(getName() + " performs a Backstab on " + target.getName() + " for " + damage + " damage! (Costs " + energyCost + " energy)");
            target.takeDamage(damage);
        } else {
            System.out.println(getName() + " doesn't have enough energy for Backstab!");
            executeAttack(target);
        }
    }

    @Override
    public String describeActions() {
        return "1. Quick Slash\n2. Backstab";
    }

    @Override
    public String toString() {
        return getName() + " (Rogue) " + super.toString() + " [ENERGY: " + energy + "/" + maxEnergy + "]";
    }
}

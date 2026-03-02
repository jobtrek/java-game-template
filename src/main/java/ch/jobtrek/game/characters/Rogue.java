package ch.jobtrek.game.characters;

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

    public void setEnergy(int energy) {
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > maxEnergy) {
            this.energy = maxEnergy;
        } else {
            this.energy = energy;
        }
    }

    @Override
    public void onTurnStart() {
        int regen = 15;
        setEnergy(getEnergy() + regen);
        System.out.println(getName() + " regenerates " + regen + " energy.");
    }

    @Override
    public void executeAttack(Character target) {
        int damage = Math.max(1, getPower() - target.getDefense());
        if (this.getSpeed() > target.getSpeed()) {
            damage += 5;
            System.out.print("(Speed bonus! +5) ");
        }
        System.out.println(getName() + " performs a quick slash on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void useSpecialAbility(Character target) {
        int energyCost = 40;
        if (getEnergy() >= energyCost) {
            setEnergy(getEnergy() - energyCost);
            int damage = Math.max(1, (int)(getPower() * 2.5) - target.getDefense());
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
        return "Rogue " + super.toString() + " [ENERGY: " + energy + "/" + maxEnergy + "]";
    }
}

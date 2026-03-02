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
    public void executeAttack(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " performs a quick slash on " + target.getName());
    }

    @Override
    public void useSpecialAbility(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " performs a Backstab on " + target.getName());
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

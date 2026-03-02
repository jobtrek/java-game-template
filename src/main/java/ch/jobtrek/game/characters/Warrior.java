package ch.jobtrek.game.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 120, 15, 12, 6);
    }

    @Override
    public void executeAttack(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " performs a basic attack on " + target.getName());
    }

    @Override
    public void useSpecialAbility(Character target) {
        // Placeholder for Task 07
        System.out.println(getName() + " uses Power Strike on " + target.getName());
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

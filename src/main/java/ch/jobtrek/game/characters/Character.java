package ch.jobtrek.game.characters;

public abstract class Character {
    private String name;
    private int hp;
    private int maxHp;
    private int power;
    private int defense;
    private int speed;

    public Character(String name, int maxHp, int power, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getPower() {
        return power;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHp(int hp) {
        this.hp = Math.clamp(hp, 0, maxHp);
    }

    public void takeDamage(int amount) {
        setHp(this.hp - amount);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void onTurnStart() {
        // Default implementation: nothing
    }

    public abstract void executeAttack(Character target);

    public abstract void useSpecialAbility(Character target);

    public abstract String describeActions();

    @Override
    public String toString() {
        return String.format("[HP: %d/%d, POW: %d, DEF: %d, SPD: %d]",
                             hp, maxHp, power, defense, speed);
    }
}

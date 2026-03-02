package ch.jobtrek.game;
import ch.jobtrek.game.characters.Character;


/**
 * Java main entrypoint class
 */
public class Main {
    public static void main(String[] args) {
        Character hero = new Character("Hero", 100, 15, 10, 8);
        System.out.println("Testing encapsulation in Character class:");
        System.out.println("Initial status: " + hero);
        
        System.out.println("Taking 20 damage...");
        hero.takeDamage(20);
        System.out.println("Current status: " + hero);
        
        System.out.println("Taking 100 damage...");
        hero.takeDamage(100);
        System.out.println("Current status: " + hero);
        
        System.out.println("Trying to heal 500 hp...");
        hero.setHp(500);
        System.out.println("Current status: " + hero);
    }
}

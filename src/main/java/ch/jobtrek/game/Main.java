package ch.jobtrek.game;
import ch.jobtrek.game.characters.Character;
import ch.jobtrek.game.characters.Warrior;
import ch.jobtrek.game.characters.Mage;
import ch.jobtrek.game.characters.Rogue;


/**
 * Java main entrypoint class
 */
public class Main {
    public static void main(String[] args) {
        // Polymorphism: treating specific types as the base Character type
        Character player = new Warrior("Aragon");
        Character enemy = new Mage("Gandalf");

        System.out.println("Testing polymorphism:");
        System.out.println("Player: " + player);
        System.out.println("Enemy: " + enemy);
        
        System.out.println("\n--- Round 1 ---");
        player.onTurnStart();
        player.executeAttack(enemy);
        
        enemy.onTurnStart();
        enemy.useSpecialAbility(player);
        
        System.out.println("\nStatus after Round 1:");
        System.out.println(player);
        System.out.println(enemy);
    }
}

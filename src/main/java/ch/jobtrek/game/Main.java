package ch.jobtrek.game;
import ch.jobtrek.game.characters.Character;
import ch.jobtrek.game.characters.Warrior;
import ch.jobtrek.game.characters.Mage;
import ch.jobtrek.game.characters.Rogue;
import ch.jobtrek.game.rules.CombatRules;


/**
 * Java main entrypoint class
 */
public class Main {
    public static void main(String[] args) {
        Character player = new Rogue("Legolas");
        Character enemy = new Warrior("Gimli");

        System.out.println("Testing CombatRules:");
        System.out.println("Player: " + player);
        System.out.println("Enemy: " + enemy);
        
        Character first = CombatRules.getFirstAttacker(player, enemy);
        System.out.println("First to attack: " + first.getName());
        
        System.out.println("\n--- Round 1 (Multiple attempts to see variance) ---");
        for (int i = 0; i < 3; i++) {
            System.out.print("Attempt " + (i+1) + ": ");
            player.executeAttack(enemy);
        }
    }
}

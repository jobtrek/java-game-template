package ch.jobtrek.game;
import ch.jobtrek.game.characters.Warrior;
import ch.jobtrek.game.characters.Mage;
import ch.jobtrek.game.characters.Rogue;


/**
 * Java main entrypoint class
 */
public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Gimli");
        Mage mage = new Mage("Gandalf");
        Rogue rogue = new Rogue("Legolas");

        System.out.println("Testing inheritance with specialized classes:");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(rogue);
        
        System.out.println("\nTesting placeholder actions:");
        warrior.executeAttack(mage);
        mage.useSpecialAbility(rogue);
        rogue.executeAttack(warrior);
    }
}

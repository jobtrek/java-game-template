package ch.jobtrek.game;

import ch.jobtrek.game.characters.Character;
import ch.jobtrek.game.characters.Warrior;
import ch.jobtrek.game.characters.Mage;
import ch.jobtrek.game.engine.BattleEngine;
import java.util.Scanner;


/**
 * Java main entrypoint class
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Starting a quick demo battle...");
        Character player = new Warrior("Aragon");
        Character enemy = new Mage("Gandalf");

        BattleEngine engine = new BattleEngine(player, enemy, scanner);
        engine.startBattle();
        
        scanner.close();
    }
}

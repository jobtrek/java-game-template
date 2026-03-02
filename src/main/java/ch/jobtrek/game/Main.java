package ch.jobtrek.game;

import ch.jobtrek.game.characters.Character;
import ch.jobtrek.game.characters.Mage;
import ch.jobtrek.game.characters.Rogue;
import ch.jobtrek.game.characters.Warrior;
import ch.jobtrek.game.engine.BattleEngine;
import java.util.Random;
import java.util.Scanner;


/**
 * Java main entrypoint class
 */
public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcome();

        boolean playAgain = true;
        while (playAgain) {
            Character player = selectCharacter(scanner);
            Character opponent = createOpponent(player);

            BattleEngine engine = new BattleEngine(player, opponent, scanner);
            engine.startBattle();

            playAgain = askPlayAgain(scanner);
        }

        displayGoodbye();
        scanner.close();
    }

    private static void displayWelcome() {
        System.out.println("========================================");
        System.out.println("   WELCOME TO JAVA MINI GAME BATTLE!    ");
        System.out.println("========================================");
    }

    private static Character selectCharacter(Scanner scanner) {
        System.out.println("\n=== CHARACTER SELECTION ===");
        System.out.println("1. Warrior  — High HP & Defense, low Speed");
        System.out.println("   HP: 120 | POW: 15 | DEF: 12 | SPD: 6");
        System.out.println("   Attacks: Sword Slash, Power Strike");
        System.out.println("\n2. Mage    — High Power, has Mana for spells");
        System.out.println("   HP: 80  | POW: 20 | DEF: 5  | SPD: 8");
        System.out.println("   Attacks: Magic Bolt, Fireball");
        System.out.println("\n3. Rogue   — High Speed, uses Energy for tricks");
        System.out.println("   HP: 90  | POW: 13 | DEF: 7  | SPD: 14");
        System.out.println("   Attacks: Quick Slash, Backstab");

        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.print("\nChoose your class (1-3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please pick between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        if (name.isBlank()) {
            name = "Hero";
        }

        return switch (choice) {
            case 1 -> new Warrior(name);
            case 2 -> new Mage(name);
            case 3 -> new Rogue(name);
            default -> throw new IllegalStateException("Unexpected choice: " + choice);
        };
    }

    private static Character createOpponent(Character player) {
        String[] names = {"Thorin", "Morgana", "Shadow", "Ignis", "Valeria"};
        String opponentName = names[random.nextInt(names.length)];

        int choice;
        do {
            choice = random.nextInt(1, 4);
        } while ((choice == 1 && player instanceof Warrior) ||
                 (choice == 2 && player instanceof Mage) ||
                 (choice == 3 && player instanceof Rogue));

        return switch (choice) {
            case 1 -> new Warrior(opponentName);
            case 2 -> new Mage(opponentName);
            case 3 -> new Rogue(opponentName);
            default -> throw new IllegalStateException("Unexpected opponent choice: " + choice);
        };
    }

    private static boolean askPlayAgain(Scanner scanner) {
        System.out.print("\nDo you want to play again? (y/n): ");
        String answer = scanner.nextLine().toLowerCase();
        return answer.startsWith("y");
    }

    private static void displayGoodbye() {
        System.out.println("\nThanks for playing! Goodbye.");
    }
}

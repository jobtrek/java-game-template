package ch.jobtrek.game.engine;

import ch.jobtrek.game.characters.Character;
import ch.jobtrek.game.rules.CombatRules;
import java.util.Scanner;

public class BattleEngine {
    private final Character player;
    private final Character opponent;
    private final Scanner scanner;
    private int round = 1;

    public BattleEngine(Character player, Character opponent, Scanner scanner) {
        this.player = player;
        this.opponent = opponent;
        this.scanner = scanner;
    }

    public void startBattle() {
        System.out.println("\n=== BATTLE START! ===");
        System.out.println(player.getName() + " vs " + opponent.getName());

        while (player.isAlive() && opponent.isAlive()) {
            System.out.println("\n--------------------");
            System.out.println("ROUND " + round);
            System.out.println("--------------------");
            System.out.println("Player: " + player);
            System.out.println("Enemy:  " + opponent);

            Character first = CombatRules.getFirstAttacker(player, opponent);
            Character second = (first == player) ? opponent : player;

            executeTurn(first, second);
            if (second.isAlive()) {
                executeTurn(second, first);
            }

            round++;
        }

        displayResult();
    }

    private void executeTurn(Character attacker, Character target) {
        System.out.println("\nIt's " + attacker.getName() + "'s turn!");
        attacker.onTurnStart();

        if (attacker == player) {
            handlePlayerTurn(target);
        } else {
            handleAITurn(attacker, target);
        }
    }

    private void handlePlayerTurn(Character target) {
        System.out.println("Choose your action:");
        System.out.println(player.describeActions());
        
        int choice = ch.jobtrek.game.Main.readValidInt(scanner, "Choice (1-2): ", 1, 2);

        if (choice == 1) {
            player.executeAttack(target);
        } else {
            player.useSpecialAbility(target);
        }
    }

    private void handleAITurn(Character ai, Character target) {
        // Simple AI: 50% chance for special if it makes sense (random choice for now)
        if (Math.random() > 0.5) {
            ai.useSpecialAbility(target);
        } else {
            ai.executeAttack(target);
        }
    }

    private void displayResult() {
        System.out.println("\n=== BATTLE OVER ===");
        if (player.isAlive()) {
            System.out.println("Victory! " + player.getName() + " won in " + (round - 1) + " rounds.");
        } else {
            System.out.println("Defeat! " + opponent.getName() + " defeated " + player.getName() + ".");
        }
    }
}

package ch.jobtrek.game.engine;

import java.util.Scanner;

public final class InputUtils {

    private InputUtils() {}

    public static int readValidInt(Scanner scanner, String prompt, int min, int max) {
        int choice = min - 1;
        while (choice < min || choice > max) {
            System.out.print(prompt);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please pick between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }
}

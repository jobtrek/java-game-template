package ch.jobtrek.game.rules;

import ch.jobtrek.game.characters.Character;
import java.util.Random;

public final class CombatRules {
    private static final Random random = new Random();

    private CombatRules() {} // Prevent instantiation

    public static int calculateDamage(int attackerPower, double abilityModifier, int targetDefense) {
        int rawDamage = (int) (attackerPower * abilityModifier) - targetDefense;
        return Math.max(1, rawDamage);
    }

    public static Character getFirstAttacker(Character c1, Character c2) {
        if (c1.getSpeed() > c2.getSpeed()) {
            return c1;
        } else if (c2.getSpeed() > c1.getSpeed()) {
            return c2;
        } else {
            return random.nextBoolean() ? c1 : c2;
        }
    }

    public static int applyDamageVariance(int baseDamage) {
        // Variance ±15% (85% to 115%)
        double variance = 0.85 + (random.nextDouble() * 0.30);
        return (int) Math.round(baseDamage * variance);
    }
}

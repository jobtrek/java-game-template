package ch.jobtrek.game.characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void takeDamage_reducesHpCorrectly() {
        // Arrange
        Warrior warrior = new Warrior("TestDummy");
        int initialHp = warrior.getHp();

        // Act
        warrior.takeDamage(10);

        // Assert
        assertEquals(initialHp - 10, warrior.getHp(), "HP should be reduced by 10");
    }

    @Test
    void takeDamage_hpDoesNotDropBelowZero() {
        // Arrange
        Warrior warrior = new Warrior("TestDummy");

        // Act
        warrior.takeDamage(9999);

        // Assert
        assertEquals(0, warrior.getHp(), "HP should not drop below 0");
    }

    @Test
    void setHp_clampedToMaxHp() {
        // Arrange
        Warrior warrior = new Warrior("TestDummy");
        int maxHp = warrior.getHp(); // Warrior starts at maxHp (120)

        // Act
        warrior.setHp(maxHp + 100);

        // Assert
        assertEquals(maxHp, warrior.getHp(), "HP should be clamped to maxHP");
    }

    @Test
    void isAlive_returnsCorrectStatus() {
        // Arrange
        Warrior warrior = new Warrior("TestDummy");

        // Assert
        assertTrue(warrior.isAlive(), "Character should be alive at start");

        // Act
        warrior.takeDamage(9999);

        // Assert
        assertFalse(warrior.isAlive(), "Character should be dead after massive damage");
    }
}

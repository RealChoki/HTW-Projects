package spells;

import model.Spell;
import monsters.Dragon;

/**
 * 
 * The ZaDiarrhea class represents a specific spell called "ZA DIARRHEA". It
 * extends the Spell class
 * and provides the implementation for the attack() method.
 */
public class ZaDiarrhea extends Spell {
    /**
     * 
     * Constructs a ZaDiarrhea object with the predefined attributes for the "ZA
     * DIARRHEA" spell.
     */
    public ZaDiarrhea() {
        super("ZA DIARRHEA", 150, 80, 6, 69);
    }

    /**
     * 
     * Performs an attack with the "ZA DIARRHEA" spell. It calculates the hit
     * probability, checks
     * if the attack hits the target, and determines the damage inflicted based on
     * the target's
     * attribute.
     * 
     * @return the damage caused by the spell
     */
    public int attack() {
        System.out.println(this.getName() + "!");

        int randNum = (int) (Math.random() * 100) + 1;

        if (randNum >= this.hitProbability) {
            System.out.println("*missed* :(");
            return 0;
        }

        Dragon dragon = new Dragon();
        // Diarrhea gets splattered everywhere against wind
        if (dragon.getAttribute().equals("wind")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}
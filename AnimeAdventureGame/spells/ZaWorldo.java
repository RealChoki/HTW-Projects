package spells;

import model.Spell;
import monsters.BrownBeard;

/**
 * Represents the ZaWorldo spell, extending the Spell class.
 * ZaWorldo is a spell that can be used to attack opponents.
 */
public class ZaWorldo extends Spell {
    /**
     * Constructs a new ZaWorldo spell with the default name "ZA WORLDO",
     * a damage value of 120, a hit probability of 75%,
     * and a mana cost of 21.
     */
    public ZaWorldo() {
        super("ZA WORLDO", 120, 75, 5, 21);
    }

    /**
     * Performs an attack using the ZaWorldo spell.
     *
     * @return the amount of damage dealt
     */
    public int attack() {
        System.out.println(this.getName() + "!");

        int randNum = (int) (Math.random() * 100) + 1;
        if (randNum >= this.hitProbability) {
            System.out.println("*missed* :(");
            return 0;
        }

        BrownBeard brownBeard = new BrownBeard();

        // Zaza makes you ignore time
        if (brownBeard.getAttribute().equals("zaza")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}


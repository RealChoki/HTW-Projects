package spells;

import model.Spell;
import monsters.Akainu;

/**
 * Represents the ZaWinda spell, extending the Spell class.
 * ZaWinda is a spell that can be used to attack opponents.
 */
public class ZaWinda extends Spell {
    /**
     * Constructs a new ZaWinda spell with the default name "ZA WINDA",
     * a damage value of 900, a hit probability of 90%,
     * and a mana cost of 696.
     */
    public ZaWinda() {
        super("ZA WINDA", 900, 90, 90, 696);
    }

    /**
     * Performs an attack using the ZaWinda spell.
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

        Akainu akainu = new Akainu();

        // Wind > Magma because it cools magma down 
        if (akainu.getAttribute().equals("magma")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}

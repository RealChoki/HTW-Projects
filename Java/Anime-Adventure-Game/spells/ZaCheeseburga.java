package spells;

import monsters.DonKrieg;
import monsters.DonaldTrump;
import model.Spell;

/**
 * The ZaCheeseburga class represents a specific spell called "ZA CHEESEBURGA".
 * It extends the Spell class
 * and provides the implementation for the attack() method.
 */
public class ZaCheeseburga extends Spell {

    /**
     * Constructs a ZaCheeseburga object with the predefined attributes for the "ZA
     * CHEESEBURGA" spell.
     */
    public ZaCheeseburga() {
        super("ZA CHEESEBURGA", 200, 20, 60, 145);
    }

    /**
     * Performs an attack with the "ZA CHEESEBURGA" spell. It calculates the hit
     * probability, checks
     * if the attack hits the target, and determines the damage inflicted based on
     * the targets' attributes.
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

        DonKrieg donKrieg = new DonKrieg();
        DonaldTrump donaldTrump = new DonaldTrump();

        // Because cheeseburger is timeless or cheeseburger makes America fat
        if (donKrieg.getAttribute().equals("time") || donaldTrump.getAttribute().equals("america")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}

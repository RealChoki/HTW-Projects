package spells;

import model.Spell;
import monsters.DonKrieg;

/**
 * Represents the ZaZa spell, extending the Spell class.
 * ZaZa is a spell that can be used to attack opponents.
 */
public class ZaZa extends Spell {
    /**
     * Constructs a new ZaZa spell with the default name "ZA ZA",
     * a damage value of 420, a hit probability of 69%,
     * and a mana cost of 69.
     */
    public ZaZa() {
        super("ZA ZA", 420, 69, 69, 420);
    }

    /**
     * Performs an attack using the ZaZa spell.
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

        DonKrieg donKrieg = new DonKrieg();

        // Time flies faster (stronger) when you're on ZaZa
        if (donKrieg.getAttribute().equals("time")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}

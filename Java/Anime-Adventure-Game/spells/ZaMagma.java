package spells;

import model.Spell;
import monsters.Gaimon;

/**
 * Represents the ZaMagma spell, extending the Spell class.
 * ZaMagma is a spell that can be used to attack opponents.
 */
public class ZaMagma extends Spell {
    /**
     * Constructs a new ZaMagma spell with the default name "ZA MAGMA",
     * a damage value of 20, a hit probability of 100%,
     * and a mana cost of 66.
     */
    public ZaMagma() {
        super("ZA MAGMA", 40, 100, 1, 66);
    }

    /**
     * Performs an attack using the ZaMagma spell.
     *
     * @return the amount of damage dealt
     */
    public int attack() {
        System.out.println(this.getName() + "!");

        int randNum = (int) (Math.random() * 100) + 1;
        if (randNum > this.hitProbability) {
            System.out.println("*missed* :(");
            return 0;
        }

        Gaimon gaimon = new Gaimon();

        // Magma > Gum || Chest
        if (gaimon.getAttribute().equals("chest")) {
            return this.damage * 2;
        }

        return this.damage;
    }
}


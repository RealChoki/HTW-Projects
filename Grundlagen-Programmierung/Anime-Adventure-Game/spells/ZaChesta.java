package spells;

import model.Spell;
import monsters.Shanks;

/**
 * The ZaChesta class represents a specific spell called "ZA CHESTA". It extends the Spell class
 * and provides the implementation for the attack() method.
 */
public class ZaChesta extends Spell {

  /**
   * Constructs a ZaChesta object with the predefined attributes for the "ZA CHESTA" spell.
   */
  public ZaChesta() {
    super("ZA CHESTA", 666, 70, 2, 666);
  }

  /**
   * Performs an attack with the "ZA CHESTA" spell. It calculates the hit probability, checks
   * if the attack hits the target, and determines the damage inflicted based on the target's
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

    Shanks shanks = new Shanks();

    // Chests are well protected against diarrheas
    if (shanks.getAttribute().equals("diarrhea")) {
      return this.damage * 2;
    }

    return this.damage;
  }
}

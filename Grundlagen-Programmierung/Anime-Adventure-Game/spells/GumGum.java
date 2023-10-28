package spells;

import monsters.Gaimon;
import model.Spell;

/**
 * The GumGum class represents a specific spell called "Gum Gum Pistol". It extends the Spell class
 * and provides the implementation for the attack() method.
 */
public class GumGum extends Spell {

  /**
   * Constructs a GumGum object with the predefined attributes for the "Gum Gum Pistol" spell.
   */
  public GumGum() {
    super("Gum Gum Pistol", 50, 90, 1, 0);
  }

  /**
   * Performs an attack with the "Gum Gum Pistol" spell. It calculates the hit probability, checks
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

    // Gum < Chest
    Gaimon gaimon = new Gaimon();
    if (gaimon.getAttribute().equals("chest")) {
      return this.damage - 5;
    }

    return this.damage;
  }
}

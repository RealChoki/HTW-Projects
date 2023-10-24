/**

The ZaWater class represents a water-based spell.
It extends the Spell class and overrides the attack() method.
*/
package spells;
import model.Spell;
import monsters.Akainu;

public class ZaWater extends Spell {

/**
 * Constructs a `ZaWater` object with the specified attributes.
 */
public ZaWater() {
    super("ZA WATER", 1000, 90, 999, 1000);
}

/**
 * Performs an attack using the water spell.
 * 
 * @return the damage inflicted by the spell
 */
public int attack() {
    System.out.println(this.getName() + "!");

    int randNum = (int) (Math.random() * 100) + 1;
    if (randNum >= this.hitProbability) {
        System.out.println("*missed* :(");
        return 0;
    }
    
    Akainu akainu = new Akainu();
    // Water > magma 
    if (akainu.getAttribute().equals("magma")) {
        return this.damage * 2;
    }
    return this.damage;
}
}
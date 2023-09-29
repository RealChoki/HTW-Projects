package model;

import spells.ZaMagma;
import spells.ZaChesta;
import spells.ZaWorldo;
import spells.ZaDiarrhea;
import spells.ZaCheeseburga;
import spells.ZaZa;
import spells.ZaWinda;
import spells.ZaWater;

/**
 * Represents a master wizard who can create magicians and manage spells.
 */
public class MasterWizard {
    private static String name = "Silvers Rayleigh";
    public static Spell[] spells;
    public static Spell[] availableSpells;
    private static Magician magician;

    /**
     * Creates a new magician with the name "Luffy" and the attribute "gum".
     *
     * @return the created magician
     */
    public static Magician createMagician() {
        magician = new Magician("Luffy", "gum");
        return magician;
    }

    static {
        spells = new Spell[8];
        spells[0] = new ZaMagma();
        spells[1] = new ZaChesta();
        spells[2] = new ZaWorldo();
        spells[3] = new ZaDiarrhea();
        spells[4] = new ZaCheeseburga();
        spells[5] = new ZaZa();
        spells[6] = new ZaWinda();
        spells[7] = new ZaWater();
    }

    /**
     * Retrieves the available spells that have not been bought yet.
     *
     * @return an array of available spells
     */
    public static Spell[] getSpells() {
        int listSize = 0;
        for (int i = 0; i < spells.length; i++) {
            if (spells[i] != null && !spells[i].isBought()) {
                listSize++;
            }
        }

        availableSpells = new Spell[listSize];
        int currIndex = 0;
        for (int i = 0; i < spells.length; i++) {
            if (spells[i] != null && !spells[i].isBought()) {
                System.out.print("(" + (currIndex + 1) + "): ");
                availableSpells[currIndex] = spells[i];
                availableSpells[currIndex].getStats();
                currIndex++;
            }
        }

        return availableSpells;
    }

    /**
     * Retrieves the name of the master wizard.
     *
     * @return the name of the master wizard
     */
    public static String getName() {
        return name;
    }

}


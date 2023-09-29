/**
 * Represents a spell with a name and a level.
 */
public class Spell {
    private final String name;
    private final int level;

    /**
     * Constructor for the Spell class.
     *
     * @param name  The name of the spell.
     * @param level The level of the spell.
     */
    public Spell(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * Retrieves the name of the spell.
     *
     * @return The name of the spell.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the level of the spell.
     *
     * @return The level of the spell.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns a combined string of the spell's name and level.
     *
     * @return A combined string of the spell's name and level.
     */
    public String toString() {
        return "Spell Name: " + name + " / Spell Level: " + level;
    }

    /**
     * The main part of the program. Creates three spells and prints their information.
     */
    public static void main(String[] args) {
        Spell spell1 = new Spell("Za Wata", 999);
        Spell spell2 = new Spell("Za Winda", 46);
        Spell spell3 = new Spell("Serious Punch", 3);
        
        System.out.println(spell1.toString());
        System.out.println(spell2.toString());
        System.out.println(spell3.toString());
    }
}

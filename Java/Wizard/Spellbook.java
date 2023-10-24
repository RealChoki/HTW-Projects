/**
 * Represents a spellbook that holds a collection of spells.
 */
public class Spellbook {
    private String name;
    private Spell[] listOfSpells;

    /**
     * Constructs a spellbook with that contains a specified number of pages.
     * If there is less than 1 page, it gets set to 1.
     *
     * @param numPages the number of spellbook pages.
     */
    public Spellbook(int numPages) {
        if (numPages < 1) {
            numPages = 1;
        }
        listOfSpells = new Spell[numPages];
    }

    /**
     * Returns spellbook name.
     *
     * @return name of spellbook
     */
    public String getName() {
        return name;
    }

    /**
     * Sets spellbook name.
     *
     * @param name is the name of the spellbook
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns array of spells in spellbook.
     *
     * @return array of spells
     */
    public Spell[] getSpells() {
        return listOfSpells;
    }

    /**
     * Adds a spell to the spellbook.
     *
     * @param s is the spell to be added
     */
    public void learnSpell(Spell s) {
        for (int i = 0; i < listOfSpells.length; i++) {
            if (listOfSpells[i] == null) {
                listOfSpells[i] = s;
                break;
            }
        }
    }

    /**
     * Removes a spell from the spellbook with the specified name.
     *
     * @param name is the name of the spell which should be forgotted
     */
    public void forgetSpell(String name) {
        for (int i = 0; i < listOfSpells.length; i++) {
            if (listOfSpells[i].getName().equals(name)) {
                listOfSpells[i] = null;
                break;
            }
        }
    }

    /**
     * Prints spellbook name and the names of the spells it contains.
     */
    public void printBook() {
        System.out.println(this.name);
        for (Spell spell : listOfSpells) {
            if (spell != null) {
                System.out.println(spell.getName());
            }
        }
    }

    /**
     * The main part of the program. Creates a spellbook, learns spells, sets name of book, forgets a spell, and prints the spellbook.
     */
    public static void main(String[] args) {
        Spellbook book = new Spellbook(4);

        Spell fireball = new Spell("Fireball", 1);
        Spell iceball = new Spell("Iceball", 2);
        Spell tornado = new Spell("Tornado", 3);
        Spell bababoi = new Spell("Bababoi", 4);

        book.learnSpell(fireball);
        book.learnSpell(iceball);
        book.learnSpell(tornado);
        book.learnSpell(bababoi);

        book.setName("Choki's Book:");

        book.forgetSpell("Iceball");

        book.printBook();
    }
}

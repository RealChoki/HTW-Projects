/**
 * The Wizard class represents a wizard character.
 * It contains information about wizard's name, year of birth, and experience points.
 */
public class Wizard {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private int exp;
    
    /**
     * Constructs a Wizard object with specified first/last name, and year of birth.
     * The initial exp are set to 0.
     *
     * @param firstName is wizads first name
     * @param lastName is wizads last name
     * @param yearOfBirth the wizads year of birth
     */
    public Wizard(String firstName, String lastName, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.exp = 0;
    }
    
    /**
     * Returns wizards first name.
     *
     * @return wizards first name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Returns wizards last name.
     *
     * @return the last name of the wizard
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Returns wizards year of birth.
     *
     * @return the year of birth of the wizard
     */
    public int getYearOfBirth(){
        return yearOfBirth;
    }
    
    /**
     * Returns wizards experience points.
     *
     * @return wizard experience points
     */
    public int getExp(){
        return exp;
    }

    /**
     * Adds specified amount of experience points to the wizard.
     *
     * @param points the number of experience points to add
     */
    public void addExp(int points){
        this.exp += points;
    }

    /**
     * Casts a spell with the given Spell object.
     * The success of the spell casting is randomized.
     * If the spell is successfully cast, the wizard gains experience points based on the spell's level.
     *
     * @param s the spell to be cast
     */
    public void castSpell(Spell s){
        int castingChance = (int) (Math.random() * 100);
        if(castingChance <= 75){
            System.out.println(s);
            addExp(s.getLevel());
        } else {
            System.out.println("Brzl");
        }
    }

    /**
     * Returns a string representation of the wizard, including the first/last name, year of birth, and experience points.
     *
     * @return a string representation of the wizard
     */
    @Override
    public String toString(){
        return firstName + " " + lastName + " !!!" + "\nYear of Birth: " + yearOfBirth + "\nExp: " + exp;
    }

    /**
     * Creates instances of Wizards and Spell objects,
     * Casts random spells for two wizards, and determines the winner based on the amount of experience points.
     */
    public static void main(String[] args){
        Wizard firstWizard = new Wizard("Luffy", "Monkey.D", 1997);
        Wizard secondWizard = new Wizard("Arlong", "The Saw", 1950);

        Spell[] spells = {
            new Spell("Za Wata", 999),
            new Spell("Za Winda", 46),
            new Spell("Za Timeu", 77),
            new Spell("Za Dragon", 221),
            new Spell("Gear 2", 12),
            new Spell("Gear 3", 23),
            new Spell("Gear 4", 33),
            new Spell("Gear 5", 133)
        };

        for (int i = 0; i < 100; i++) {
            Spell randomSpell = spells[(int) (Math.random() * spells.length)];

            firstWizard.castSpell(randomSpell);
            secondWizard.castSpell(randomSpell);
        }

        if(firstWizard.getExp() > secondWizard.getExp()){
            System.out.println("The Winner is " + firstWizard.toString());
        }else if(firstWizard.getExp() < secondWizard.getExp()){
            System.out.println("The Winner is " + secondWizard.toString());
        }else{
            System.out.println("It's a Draw !!!");
        }
    }
}

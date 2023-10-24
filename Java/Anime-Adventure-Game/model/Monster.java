package model;

public abstract class Monster {
    private String name;
    private int level;
    public int lifePoints;
    private int damage;
    private String attribute;
    private Spell spell;
    private int money;
    public boolean isAlive;

    /**
     * Constructs a Monster object with the given name, attribute, and spell.
     *
     * @param name      the name of the monster
     * @param attribute the attribute of the monster
     * @param spell     the spell of the monster
     */
    public Monster(String name, String attribute, Spell spell) {
        this.name = name;
        this.attribute = attribute;
        this.spell = spell;
        this.isAlive = true;
    }

    /**
     * Calculates the attack points of the monster based on its spell.
     *
     * @return the attack points of the monster
     */
    public int attack() {
        int monstersDmg = this.spell.attack() + this.damage;
        return monstersDmg;
    }

    /**
     * Displays an introduction for the monster.
     */
    public abstract void intro();

    /**
     * Displays a victory outro for the monster.
     */
    public abstract void winOutro();

    /**
     * Displays a defeat outro for the monster.
     */
    public abstract void loseOutro();

    /**
     * Reduces the monster's life points by the specified damage value.
     * If the reduced life points are greater than 0, it prints the remaining
     * life points of the monster. Otherwise, it prints a defeat message.
     *
     * @param dmg the amount of damage to be inflicted on the monster
     * @return the remaining life points of the monster
     */
    public int getDamaged(int dmg) {
        int reducedHP = this.lifePoints -= dmg;

        if (reducedHP > 0) {
            System.out.println(this.name + ": " + reducedHP + "HP");
            System.out.println();
        } else {
            System.out.println();
            System.out.println(this.name + ": 0HP");
            System.out.println("You won against " + this.name);
            System.out.println();
        }
        return this.lifePoints;
    }

    /**
     * Displays the stats of the monster, including its name, life points,
     * level, money, and attribute.
     */
    public void getStats() {
        System.out.println(
                this.name + ": \n" +
                        this.lifePoints + " HP \n" +
                        this.level + " lvl \n" +
                        "Money: " + this.money + "\n" +
                        "Attribute: " + this.attribute + "\n");
    }

    /**
     * Retrieves the current life points of the monster.
     *
     * @return the current life points of the monster
     */
    public int getHealth() {
        return this.lifePoints;
    }

    /**
     * Retrieves the amount of money possessed by the monster.
     *
     * @return the amount of money possessed by the monster
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Retrieves the dialog name of the monster.
     *
     * @return the dialog name of the monster
     */
    public String getDialogName() {
        return this.name + ": ";
    }

    /**
     * Sets the death status of the monster to "dead".
     *
     * @return true if the monster is dead, false otherwise
     */
    public boolean setDeath() {
        this.isAlive = false;
        return this.isAlive;
    }

    /**
     * Sets the level of the monster and updates its life points and money based on
     * the level.
     *
     * @param level the level to set for the monster
     */
    public void setLevel(int level) {
        this.lifePoints = level * 100;
        this.money = level * 50;
        this.level = level;
        this.damage = level * 50;
    }

    /**
     * Displays a story line for the monster.
     *
     * @param story the story line to be displayed
     */
    public void storyLine(String story) {
        System.out.println(story);
    }

    /**
     * Retrieves the attribute of the monster.
     *
     * @return the attribute of the monster
     */
    public String getAttribute() {
        return this.attribute;
    }
}
package model;

import java.io.Serializable;
import java.util.Scanner;

import static utils.ReadUserInput.readUserInput;
import utils.StopWatch;

/**
 * The Spell class represents a spell in a game. It is an abstract class that
 * provides common
 * attributes and methods for different types of spells.
 */
public abstract class Spell implements Serializable {

  private static final long serialVersionUID = 1L;

  private String incantation;
  public int damage;
  public int hitProbability;
  private int level;
  private boolean isBought;
  private int price;

  /**
   * Constructs a Spell object with the specified attributes.
   *
   * @param incantation    the incantation of the spell
   * @param damage         the damage caused by the spell
   * @param hitProbability the probability of the spell hitting the target
   * @param level          the level of the spell
   * @param price          the price of the spell
   */
  public Spell(String incantation, int damage, int hitProbability, int level, int price) {
    this.incantation = incantation;
    this.damage = damage;
    this.hitProbability = hitProbability;
    this.level = level;
    this.isBought = false;
    this.price = price;
  }

  /**
   * Trains the spell by improving the incantation based on user input.
   *
   * @return the updated level of the spell
   */
  public int train() {
    System.out.println(
        "A countdown will start after Pressing 'Enter'. Proceed to type in the incantation after the appearance of 'GO!' to improve your spell.");

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    System.out.print("3 | ");
    try {
      Thread.sleep(500);
      System.out.print("2 | ");
      Thread.sleep(500);
      System.out.print("1 | ");
      Thread.sleep(500);
      System.out.println("GO!");
      System.out.println("----------------");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Type in: " + this.incantation);
    StopWatch.start();

    String input = readUserInput();

    StopWatch.stop();

    long timeNeeded = (this.incantation.length()) / (this.level + 1) * 1000;
    boolean isValidTime = StopWatch.executedBefore(timeNeeded);

    if (input.equalsIgnoreCase(this.incantation) && isValidTime) {
      System.out.println("Well done!! The spell '" + this.incantation + "' has been improved!");
      this.damage = this.damage + (this.level * 5);
      this.level++;
      return this.level;
    } else {
      System.out.println("Too slow.. The spell '" + this.incantation + "' did not get improved.");
      return this.level;
    }
  }

  /**
   * Performs an attack with the spell.
   *
   * @return the damage caused by the spell
   */
  public abstract int attack();

  /**
   * Prints the statistics of the spell, including the incantation, damage, hit
   * probability, level,
   * and price.
   */
  public void getStats() {
    System.out.print(
        this.incantation + ":  " +
            this.damage + " Attack damage,  " +
            this.hitProbability + "% Success rate,  " +
            "lvl " + this.level + ",  $" + this.price + ".\n");
  }

  /**
   * Returns the incantation of the spell.
   *
   * @return the incantation
   */
  public String getName() {
    return this.incantation;
  }

  /**
   * Returns the level of the spell.
   *
   * @return the level
   */
  public int getLevel() {
    return this.level;
  }

  /**
   * Returns the price of the spell.
   *
   * @return the price
   */
  public int getPrice() {
    return this.price;
  }

  /**
   * Checks if the spell has been bought.
   *
   * @return true if the spell has been bought, false otherwise
   */
  public boolean isBought() {
    return this.isBought;
  }

  /**
   * Marks the spell as bought.
   *
   * @return true if the spell is successfully marked as bought
   */
  public boolean buy() {
    return this.isBought = true;
  }
}

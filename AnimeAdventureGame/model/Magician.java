package model;

import java.io.Serializable;

/**
 * Represents a magician with various attributes and abilities.
 * This class implements the Serializable interface.
 */
public class Magician implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Spell[] spells;
    private Spell[] availableSpells;
    private int lifePoints;
    private int exp;
    private String attribute;
    private int wallet;
    public boolean isAlive;

    /**
     * Constructs a new Magician object with the given name and attribute.
     *
     * @param name      the name of the magician
     * @param attribute the attribute of the magician
     */
    public Magician(String name, String attribute) {
        this.name = name;
        this.spells = new Spell[5];
        this.lifePoints = 1000;
        this.exp = 0;
        this.attribute = attribute;
        this.wallet = 100;
        this.isAlive = true;
    }

    /**
     * Returns the level of the magician based on their experience points.
     *
     * @return the level of the magician
     */
    public int getLevel() {
        return (int) Math.sqrt(exp);
    }

    /**
     * Retrieves the available spells of the magician.
     *
     * @return an array of available spells
     */
    public Spell[] getSpells() {
        int listSize = 0;
        for (int i = 0; i < spells.length; i++) {
            if (spells[i] != null) {
                listSize++;
            }
        }

        availableSpells = new Spell[listSize];
        int currIndex = 0;
        for (int i = 0; i < spells.length; i++) {
            if (spells[i] != null) {
                System.out.print("(" + (currIndex + 1) + "): ");
                availableSpells[currIndex] = spells[i];
                availableSpells[currIndex].getStats();
                currIndex++;
            }
        }
        return availableSpells;
    }

    /**
     * Prints the statistics of the magician, including their name, life points, level,
     * attribute, wallet balance, and spells.
     */
    public void getStats() {
        System.out.println(
                this.name + ": \n" +
                        this.lifePoints + " HP \n" +
                        getLevel() + " lvl \n" +
                        "Attribute: " + this.attribute + "\n" +
                        "Money (in Berries): " + this.wallet + "\n" +
                        "Spells: ");
        this.getSpells();
    }

    /**
     * Returns the attribute of the magician.
     *
     * @return the attribute of the magician
     */
    public String getAttribute() {
        return this.attribute;
    }

    /**
     * Flips a coin and updates the wallet balance of the magician.
     *
     * @param num the amount to be added to the wallet balance
     * @return the updated wallet balance
     */
    public int flipCoin(int num) {
        this.wallet += num;
        System.out.println("New balance: " + this.wallet);
        return this.wallet;
  }


  /**
     * Retrieves the current balance of the magician's wallet.
     *
     * @return the current balance of the magician's wallet
     */
    public int getMoney(){
      return this.wallet;
  }

  /**
   * Trains the specified spell and returns the updated spell's level.
   *
   * @param spell the spell to train
   * @return the updated level of the spell
   */
  public int trainSpell(Spell spell) {
      return spell.train();
  }

  /**
   * Performs an attack using the specified spell and returns the damage inflicted.
   *
   * @param spell the spell to use for the attack
   * @return the amount of damage inflicted
   */
  public int attack(Spell spell) {
      return spell.attack();
  }

  /**
   * Heals the magician by restoring 100 health points, consuming 1 EXP.
   * If the magician has insufficient EXP, no healing is performed.
   *
   * @return the new health points after healing
   */
  public int heal() {
      if (this.exp < 1) {
          System.out.println("Cannot heal. Insufficient EXP.");
          return this.lifePoints;
      }
      this.exp--;
      this.lifePoints += 100;
      System.out.println("Healing... New health: " + this.lifePoints);
      return this.lifePoints;
  }

  /**
   * Learns the specified spell and adds it to the magician's collection of spells.
   *
   * @param spell the spell to learn
   * @return the learned spell, or null if the magician cannot learn more spells
   */
  public Spell learnSpell(Spell spell) {
      for (int i = 0; i < this.spells.length; i++) {
          if (spells[i] == null) {
              this.spells[i] = spell;
              return spell;
          }
      }
      System.out.println("Cannot learn this Spell. You can only own 5 spells.");
      return null;
  }

  /**
   * Attempts to buy the specified spell, deducts the cost from the magician's wallet,
   * and learns the spell if the magician has enough money.
   *
   * @param spell the spell to buy
   * @return the updated wallet balance after buying the spell
   */
  public int buySpell(Spell spell) {
      int updatedMoney = this.wallet - spell.getPrice();

      if (updatedMoney > 0) {
          learnSpell(spell);
          System.out.println("New spell " + spell.getName() + " has been learned!");
          this.wallet = updatedMoney;
          return updatedMoney;
      } else {
          System.out.println("You have an insufficient amount of money");
          return this.wallet;
      }
  }

  /**
   * Increases the magician's wallet balance and experience points after winning a battle.
   *
   * @param monsterMoney the amount of money obtained from defeating a monster
   * @return the updated experience points
   */
  public int win(int monsterMoney) {
      this.wallet += monsterMoney;
      return this.exp += 10;
  }

  /**
   * Decreases the magician's health points by the specified amount of damage.
   * If the magician's health points reach 0 or below, the magician loses the battle.
   *
   * @param dmg the amount of damage to be inflicted on the magician
   * @return the remaining health points after taking the damage
   */
  public int getDamaged(int dmg) {
      int reducedHP = this.lifePoints -= dmg;
      if (reducedHP > 0) {
          System.out.println(this.name + ": " + reducedHP + " HP");
          System.out.println();
      } else if (this.lifePoints <= 0) {
          System.out.println(this.name + ": 0 HP");
          System.out.println();
          this.lose();
      }
      return this.lifePoints;
  }

  /**
   * prints out a losing screen
   */
  public boolean lose() {
    System.out.println("                             ...----....");
    System.out.println("                         ..-:\"''         ''\"-..");
    System.out.println("                      .-'                      '-.");
    System.out.println("                    .'              .     .       '.");
    System.out.println("                  .'   .          .    .      .    .''.");
    System.out.println("                .'  .    .       .   .   .     .   . ..:.");
    System.out.println("              .' .   . .  .       .   .   ..  .   . ....::.");
    System.out.println("             ..   .   .      .  .    .     .  ..  . ....:IA.");
    System.out.println("            .:  .   .    .    .  .  .    .. .  .. .. ....:IA.");
    System.out.println("           .: .   .   ..   .    .     . . .. . ... ....:.:VHA.");
    System.out.println("           '..  .  .. .   .       .  . .. . .. . .....:.::IHHB.");
    System.out.println("          .:. .  . .  . .   .  .  . . . ...:.:... .......:HIHMM.");
    System.out.println("         .:.... .   . .\"::\"'.. .   .  . .:.:.:II;,.. .. ..:IHIMMA");
    System.out.println("         ':.:..  ..::IHHHHHI::. . .  ...:.::::.,,,. . ....VIMMHM");
    System.out.println("        .:::I. .AHHHHHHHHHHAI::. .:...,:IIHHHHHHMMMHHL:. . VMMMM");
    System.out.println("       .:.:V.:IVHHHHHHHMHMHHH::..:\" .:HIHHHHHHHHHHHHHMHHA. .VMMM.");
    System.out.println("       :..V.:IVHHHHHMMHHHHHHHB... . .:VPHHMHHHMMHHHHHHHHHAI.:VMMI");
    System.out.println("       ::V..:VIHHHHHHMMMHHHHHH. .   .I\":IIMHHMMHHHHHHHHHHHAPI:WMM");
    System.out.println("       ::\". .:.HHHHHHHHMMHHHHHI.  . .:..I:MHMMHHHHHHHHHMHV:' .IHWW");
    System.out.println("       :: . :.::IIHHHHHHMMHHHHV  .ABA.:.:IMHMHMMMHMHHHHV:'. .IHWW");
    System.out.println("       '.  ..:..:.:IHHHHHMMHV\" .AVMHMA.:.'VHMMMMHHHHHV:' .  :IHWV");
    System.out.println("        :.  .:...:\".:.:TPP\"   .AVMMHMMA.:. \"VMMHHHP.:... .. :IVAI");
    System.out.println("       .:.   '... .:\"'   .   ..HMMMHMMMA::. .\"VHHI:::....  .:IHW'");
    System.out.println("       ...  .  . ..:IIPPIH: ..HMMMI.MMMV:I:.  .:ILLH:.. ...:I:IM");
    System.out.println("     : .   .'\"' .:.V\". .. .  :HMMM:IMMMI::I. ..:HHIIPPHI::'.P:HM.");
    System.out.println("     :.  .  .  .. ..:.. .    :AMMM IMMMM..:...:IV\":T::I::.\".:IHIMA");
    System.out.println("     'V:.. .. . .. .  .  .   'VMMV..VMMV :....:V:.:..:....::IHHHMH");
    System.out.println("       \"IHH:.II:.. .:. .  . . . \" :HB\"\" . . ..PI:.::.:::..:IHHMMV\"");
    System.out.println("        :IP\"\"HHII:.  .  .    . . .'V:. . . ..:IH:.:.::IHIHHMMMMM\"");
    System.out.println("        :V:. VIMA:I..  .     .  . .. . .  .:.I:I:..:IHHHHMMHHMMM");
    System.out.println("        :\"VI:.VWMA::. .:      .   .. .:. ..:.I::.:IVHHHMMMHMMMMI");
    System.out.println("        :.\"VIIHHMMA:.  .   .   .:  .:.. . .:.II:I:AMMMMMMHMMMMMI");
    System.out.println("        :..VIHIHMMMI...::.,:.,:!\"I:!\"I!I\"!\"V:AI:VAMMMMMMHMMMMMM'");
    System.out.println("        ':.:HIHIMHHA:\"!!\"I.:AXXXVVXXXXXXXA:.\"HPHIMMMMHHMHMMMMMV");
    System.out.println("          V:H:I:MA:W'I :AXXXIXII:IIIISSSSSSXXA.I.VMMMHMHMMMMMM");
    System.out.println("            'I::IVA ASSSSXSSSSBBSBMBSSSSSSBBMMMBS.VVMMHIMM'\"");
    System.out.println("             I:: VPAIMSSSSSSSSSBSSSMMBSSSBBMMMMXXI:MMHIMMI");
    System.out.println("            .I::. \"H:XIIXBBMMMMMMMMMMMMMMMMMBXIXXMMPHIIMM'");
    System.out.println("            :::I.  ':XSSXXIIIIXSSBMBSSXXXIIIXXSMMAMI:.IMM");
    System.out.println("            :::I:.  .VSSSSSISISISSSBII:ISSSSBMMB:MI:..:MM");
    System.out.println("            ::.I:.  ':\"SSSSSSSISISSXIIXSSSSBMMB:AHI:..MMM.");
    System.out.println("            ::.I:. . ..:\"BBSSSSSSSSSSSSBBBMMMB:AHHI::.HMMI");
    System.out.println("            :..::.  . ..::\":BBBBBSSBBBMMMB:MMMMHHII::IHHMI");
    System.out.println("            ':.I:... ....:IHHHHHMMMMMMMMMMMMMMMHHIIIIHMMV\"");
    System.out.println("              \"V:. ..:...:.IHHHMMMMMMMMMMMMMMMMHHHMHHMHP'");
    System.out.println("               ':. .:::.:.::III::IHHHHMMMMMHMHMMHHHHM\"");
    System.out.println("                 \"::.::.. .. .  ...:::IIHHMMMMHMV\"");

    System.out.println();
    System.out.println();

    System.out.println("     ▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄");
    System.out.println("     ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌");
    System.out.println("       ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌");
    System.out.println("       ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌");
    System.out.println("       ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓ ");
    System.out.println("       ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒ ");
    System.out.println("     ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒ ");
    System.out.println("     ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░ ");
    System.out.println("     ░ ░         ░ ░     ░           ░     ░     ░  ░   ░    ");
    System.out.println("     ░ ░                           ░                  ░      ");

    return this.isAlive = false;
  }
  /**
   * prints out winning screen
   */
  public void winGame(){
                                                                                                                                                        
    System.out.println("                                                                                  ██████                                              ");
    System.out.println("                                                                                ▓▓░░░░  ▓▓                                            ");
    System.out.println("                                                              ▓▓██            ▓▓        ░░▓▓▓▓██                                      ");
    System.out.println("                                                            ▓▓██      ▓▓▓▓▓▓██            ░░░░  ██                                    ");
    System.out.println("                                                          ░░░░██    ██░░░░░░                      ▓▓                                  ");
    System.out.println("                                                          ██  ░░▓▓▓▓                              ░░██                                ");
    System.out.println("                                                          ██    ░░░░    ▓▓██      ▓▓██              ░░▓▓                              ");
    System.out.println("                                                          ██          ██░░░░██████░░░░██                ██                            ");
    System.out.println("                                                          ██        ██░░░░░░░░░░░░░░░░▓▓▒▒    ▒▒▒▒▒▒    ██                            ");
    System.out.println("                                                          ██▒▒    ██░░░░░░░░░░░░░░░░░░░░▒▒████▓▓▒▒▒▒██  ░░██                          ");
    System.out.println("                                                        ▒▒░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░██    ██                          ");
    System.out.println("                                                        ██    ██▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓░░    ██                          ");
    System.out.println("                                                          ▒▒░░▒▒██▒▒░░░░░░░░░░░░░░░░▓▓▓▓░░░░░░░░▓▓        ██                          ");
    System.out.println("                                                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░██        ██                          ");
    System.out.println("                                                          ██░░░░░░██░░░░░░██░░░░░░░░░░░░░░░░░░░░░░██      ██                          ");
    System.out.println("                                                          ██░░░░████░░░░░░██░░░░░░██████░░░░░░░░░░░░████  ██                          ");
    System.out.println("                                                          ██░░░░████░░░░██░░░░░░░░░░░░██░░░░░░░░░░██░░░░████                          ");
    System.out.println("            ██████                                      ██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░██████                            ");
    System.out.println("          ██░░░░░░██                                    ██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░██                            ");
    System.out.println("        ██░░░░░░░░██                                    ██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░████                              ");
    System.out.println("        ██░░░░░░░░██                                    ██░░░░░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░██░░░░██                            ");
    System.out.println("        ██░░░░░░██                                      ██░░░░██████░░░░░░░░░░░░██████░░░░░░░░░░░░░░░░░░██                            ");
    System.out.println("        ██░░░░░░██                                        ██░░██    ████████████    ██░░░░░░░░░░░░░░░░░░██                            ");
    System.out.println("          ██░░░░▒▒██                                      ██░░░░██                ████░░░░░░░░░░░░░░░░██                              ");
    System.out.println("          ██░░░░░░██                                      ██░░░░░░▓▓██      ▓▓▓▓██░░░░░░░░░░░░░░░░████                                ");
    System.out.println("          ██░░░░░░▒▒▓▓                                      ██░░░░░░░░▓▓▓▓██░░░░░░░░░░░░░░░░░░░░██                                    ");
    System.out.println("  ▓▓▓▓▓▓████▓▓▓▓██░░░░▓▓                                    ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                                      ");
    System.out.println("▓▓░░░░░░░░░░░░░░░░▓▓░░▒▒██                                    ▓▓░░░░░░▓▓██░░░░░░░░░░░░░░░░░░████                                      ");
    System.out.println("██░░░░░░░░░░░░░░░░▒▒▓▓░░▒▒▓▓                                  ████░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓██░░▓▓▓▓                                  ");
    System.out.println("██░░░░░░░░░░░░░░░░░░██░░░░████▓▓▓▓▓▓▓▓▒▒              ▓▓▓▓▓▓▓▓████▓▓░░░░░░░░░░░░░░░░░░▓▓▒▒██░░  ░░████▓▓                              ");
    System.out.println("  ██████████████░░░░██░░░░██░░██▒▒▒▒▒▒▒▒██████████████▒▒▒▒▒▒▒▒▒▒██  ████░░░░░░░░██░░░░░░░░██      ██▒▒▒▒████                          ");
    System.out.println("▓▓░░░░░░░░░░░░▒▒▓▓▓▓▒▒░░░░██░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ░░░░▓▓▓▓▓▓▓▓░░░░░░░░██░░      ██▒▒▒▒▒▒▒▒▓▓▓▓                      ");
    System.out.println("██░░░░░░░░░░░░░░░░░░██░░░░██░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██          ██░░░░██████        ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                    ");
    System.out.println("██░░░░░░░░░░░░░░░░░░██░░░░██░░██▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██            ▓▓▓▓░░░░░░        ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                  ");
    System.out.println("░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░██░░░░██░░██▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓                        ▓▓██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒              ");
    System.out.println("  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒░░▓▓▓▓░░██▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                  ▒▒██▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒            ");
    System.out.println("  ██░░░░░░░░░░░░░░░░██░░██░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██              ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██          ");
    System.out.println("    ██░░░░░░░░░░░░░░██░░██░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒▒▒▒▒▒▒▒▒▒▒██            ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██        ");
    System.out.println("      ██████████████░░░░██░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████████▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓        ");
    System.out.println("        ██░░░░░░░░░░░░████░░██▓▓▓▓▓▓▓▓▓▓████████      ██▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██      ");
    System.out.println("          ████████████    ██████████████              ██▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    ");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓██");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓██");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒▒▒██        ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██  ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓██");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓██      ██▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓██");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██      ██▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██      ██▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██  ");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██    ██▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██  ");
    System.out.println("                                                      ██▒▒▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██    ██▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██    ");
    System.out.println("                                                        ██▒▒▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓██  ▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓██    ");
    System.out.println("                                                        ████▒▒▒▒▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██    ██▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓      ");
    System.out.println("                                                        ██░░████▒▒██          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██  ██▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓      ");
    System.out.println("                                                        ██  ░░░░████          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓        ");
    System.out.println("                                                        ██      ░░            ░░██████████████░░░░░░  ██  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓        ");
    System.out.println("                                                        ██                      ░░░░░░░░░░░░░░        ████▒▒██▓▓▓▓▓▓▓▓▓▓▓▓▓▓          ");
    System.out.println("                                                        ██                                            ████░░▒▒██████▓▓▓▓▓▓            ");
    System.out.println("                                                        ░░▓▓                                          ██▒▒░░░░▒▒▒▒░░██▓▓              ");
    System.out.println("                                                          ██▓▓                                        ██░░░░░░░░░░░░██▒▒▒▒            ");
    System.out.println("                                                          ██▓▓▓▓▓▓██                              ▒▒██████░░░░░░░░▓▓░░░░▓▓            ");
    System.out.println("                                                          ██▒▒▓▓▓▓▒▒▒▒▒▒▒▒██          ▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██░░░░░░▓▓██░░░░▓▓            ");
    System.out.println("                                                          ██▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓██░░░░░░████▓▓░░▓▓            ");
    System.out.println("                                                          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░▒▒▒▒░░░░▓▓            ");
    System.out.println("                                                          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▒▒              ");
    System.out.println("                                                          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░░░░░                ");
    System.out.println("                                                            ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓██████                            ");
    System.out.println("                                                                ████████████████████████████████████                                  ");
                                        

      System.out.println("__  ______  __  __  _      ______  _  __  __  __  ");
      
      System.out.println("\\ \\/ / __ \\/ / / / | | /| / / __ \\/ |/ / / / / /  ");

      System.out.println(" \\  / /_/ / /_/ /  | |/ |/ / /_/ /    / /_/ /_/   ");
      
      System.out.println(" /_/\\____/\\____/   |__/|__/\\____/_/|_/ (_) (_)    ");
          
  }
}

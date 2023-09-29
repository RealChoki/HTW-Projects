package monsters;

import model.Monster;
import spells.ZaCheeseburga;


/**
 * Represents the character Donald Trump, extending the Monster class.
 * Donald Trump is a powerful monster associated with the "america" attribute and possesses the ZaCheeseburga spell.
 */
public class DonaldTrump extends Monster {
    /**
     * Constructs a new Donald Trump monster with the default name "Donald Trump",
     * attribute "america", and the ZaCheeseburga spell.
     */
    public DonaldTrump() {
        super("Donald Trump", "america", new ZaCheeseburga());
    }

    /**
     * Displays the introduction dialogue of Donald Trump.
     */
    public void intro() {
        String story = this.getDialogName() + "I will make the Grand Line great again! " +
                "You can't stop me, Luffy. We will build the wall! A better one than the Red Line. " +
                "And only the greatest Wizards and high-skilled legal aliens shall live there.";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Donald Trump.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "Ahhhhh! Please give me a Cheeseburger, before I die OwO";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Donald Trump.
     */
    public void winOutro() {
        String story = this.getDialogName() + "You're defeated! Just like how I defeated Crooked Hillary and dethroned Number 44 (Obama). " +
                "Making the Grand Line great again! MAGA!";
        storyLine(story);
    }
}


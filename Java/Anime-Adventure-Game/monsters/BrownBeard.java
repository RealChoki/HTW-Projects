package monsters;

import model.Monster;
import spells.ZaZa;


/**
 * Represents the character Brown Beard, extending the Monster class.
 * Brown Beard is a powerful monster associated with the "zaza" attribute and possesses the ZaZa spell.
 */
public class BrownBeard extends Monster {
    /**
     * Constructs a new Brown Beard monster with the default name "Brown Beard",
     * attribute "zaza", and the ZaZa spell.
     */
    public BrownBeard() {
        super("Brown Beard", "zaza", new ZaZa());
    }

    /**
     * Displays the introduction dialogue of Brown Beard.
     */
    public void intro() {
        String story = this.getDialogName() + "I'm Brown Beard, the strongest Yonko. " +
                "We met each other on Punk Hazard, but I was secretly just observing you to see how much threat you pose to me, aka none.";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Brown Beard.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "I need that ZaZa...";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Brown Beard.
     */
    public void winOutro() {
        String story = this.getDialogName() + "If only my daddy Whitebeard and mommy Blackbeard were here to see my victory );";
        storyLine(story);
    }
}


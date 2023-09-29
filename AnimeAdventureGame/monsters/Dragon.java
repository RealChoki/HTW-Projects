package monsters;

import model.Monster;
import spells.ZaWinda;


/**
 * Represents the character Dragon, extending the Monster class.
 * Dragon is a powerful monster associated with the "wind" attribute and possesses the ZaWinda spell.
 */
public class Dragon extends Monster {
    /**
     * Constructs a new Dragon monster with the default name "Dragon",
     * attribute "wind", and the ZaWinda spell.
     */
    public Dragon() {
        super("Dragon", "wind", new ZaWinda());
    }

    /**
     * Displays the introduction dialogue of Dragon.
     */
    public void intro() {
        String story = this.getDialogName() + "Sorry, son. I wasn't abducted. " +
                "I am the most evil wizard, and I controlled Arlong, the Sea Devil, to kill you. " +
                "I never wanted you to be born; you were an accident!";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Dragon.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "I'm proud of you, son. You're strong. " +
                "Please take care of Kuma for me.";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Dragon.
     */
    public void winOutro() {
        String story = this.getDialogName() + "Such a weak maggot. I need to work on my pull-out game...";
        storyLine(story);
    }
}


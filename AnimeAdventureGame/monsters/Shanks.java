package monsters;

import model.Monster;
import spells.ZaDiarrhea;


/**
 * Represents the character Shanks, extending the Monster class.
 * Shanks is a powerful monster associated with the "diarrhea" attribute and possesses the ZaDiarrhea spell.
 */
public class Shanks extends Monster {
    /**
     * Constructs a new Shanks monster with the default name "Shanks",
     * attribute "diarrhea", and the ZaDiarrhea spell.
     */
    public Shanks() {
        super("Shanks", "diarrhea", new ZaDiarrhea());
    }

    /**
     * Displays the introduction dialogue of Shanks.
     */
    public void intro() {
        String story = this.getDialogName() + "Hey, Luffy. I didn't want to fight you. " +
                "But I'm a filthy snitch and I need to snitch on you to the Gorosei, " +
                "after I use my Diarrhea Haki!";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Shanks.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "*poops sadly );*";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Shanks.
     */
    public void winOutro() {
        String story = this.getDialogName() + "*poops happily (:*";
        storyLine(story);
    }
}


package monsters;

import model.Monster;
import spells.ZaWorldo;


/**
 * Represents the character Don Krieg, extending the Monster class.
 * Don Krieg is a powerful monster associated with the "time" attribute and possesses the ZaWorldo spell.
 */
public class DonKrieg extends Monster {
    /**
     * Constructs a new Don Krieg monster with the default name "Don Krieg",
     * attribute "time", and the ZaWorldo spell.
     */
    public DonKrieg() {
        super("Don Krieg", "time", new ZaWorldo());
    }

    /**
     * Displays the introduction dialogue of Don Krieg.
     */
    public void intro() {
        String story = this.getDialogName() + "Don't think you can beat me! " +
                "I am the teacher of Dio Brando from JoJo's Bizarre Adventure. ZA WOLRDO!";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Don Krieg.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "Please tell my pupil, Dio Brando, that I loved him.";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Don Krieg.
     */
    public void winOutro() {
        String story = this.getDialogName() + "I've proven once again that my power is unmatched! Victory is mine! MUDA MUDA MUDA!";
        storyLine(story);
    }
}


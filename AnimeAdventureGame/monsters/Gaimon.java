package monsters;

import model.Monster;
import spells.ZaChesta;


/**
 * Represents the character Gaimon, extending the Monster class.
 * Gaimon is a powerful monster associated with the "chest" attribute and possesses the ZaChesta spell.
 */
public class Gaimon extends Monster {
    /**
     * Constructs a new Gaimon monster with the default name "Gaimon",
     * attribute "chest", and the ZaChesta spell.
     */
    public Gaimon() {
        super("Gaimon", "chest", new ZaChesta());
    }

    /**
     * Displays the introduction dialogue of Gaimon.
     */
    public void intro() {
        String story = this.getDialogName() + "I'm Gaimon, The Chest Devil. " +
                "Let me show you the extent of my Chest Haki.";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Gaimon.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "You might have won this battle, " +
                "but you can never kill me when I hide myself in my chest. *hides*";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Gaimon.
     */
    public void winOutro() {
        String story = this.getDialogName() + "You fool! Little do you know that the true treasure, " +
                "the One Piece, is hidden right here in my chest. Twirling around my big ehm ehm...";
        storyLine(story);
    }
}


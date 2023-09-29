package monsters;

import model.Monster;
import spells.ZaMagma;



/**
 * Represents the character Akainu, extending the Monster class.
 * Akainu is a powerful monster associated with the "magma" attribute and possesses the ZaMagma spell.
 */
public class Akainu extends Monster {
    /**
     * Constructs a new Akainu monster with the default name "Akainu",
     * attribute "magma", and the ZaMagma spell.
     */
    public Akainu() {
        super("Akainu", "magma", new ZaMagma());
    }

    /**
     * Displays the introduction dialogue of Akainu.
     */
    public void intro() {
        String story = this.getDialogName() + "Son of Dragon, we meet again. " +
                "This time, your mother Crocodile is not going to save you like in Marine Ford. " +
                "I will turn you into a donut just like your filthy brother!";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Akainu.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "Noooooo. I was supposed to be the best donut maker ):";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Akainu.
     */
    public void winOutro() {
        String story = this.getDialogName() + "This one will be a good piece in my Donut Collection.";
        storyLine(story);
    }
}


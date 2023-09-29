package monsters;

import model.Monster;
import spells.ZaWater;


/**
 * Represents the character Arlong, extending the Monster class.
 * Arlong is a powerful monster associated with the "water" attribute and possesses the ZaWater spell.
 */
public class Arlong extends Monster {
    /**
     * Constructs a new Arlong monster with the default name "Arlong",
     * attribute "water", and the ZaWater spell.
     */
    public Arlong() {
        super("Arlong", "water", new ZaWater());
    }

    /**
     * Displays the introduction dialogue of Arlong.
     */
    public void intro() {
        String story = this.getDialogName() + "Don't think you can beat me this time, Luffy. " +
                "After losing against you, I trained my Blue Haki to the fullest extent and became the best wizard in this world.";
        storyLine(story);
    }

    /**
     * Displays the losing outro dialogue of Arlong.
     */
    public void loseOutro() {
        String story = this.getDialogName() + "You only won this time because we fought on land. " +
                "1v1 in water, always bet on me.";
        storyLine(story);
    }

    /**
     * Displays the winning outro dialogue of Arlong.
     */
    public void winOutro() {
        String story = this.getDialogName() + "You inferior human tried to enslave us Fishes... " +
                "and made sushi...";
        storyLine(story);
    }
}


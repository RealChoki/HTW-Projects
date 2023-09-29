package utils;

import model.Magician;

/**
 * Generates a random level for the specified magician.
 * 
 * @param magician the magician for which to generate the level
 * @return the generated level
 */
public class LevelGenerator {
    public static int generateRandomLevel(Magician magician) {
       int currentLevel = magician.getLevel();
        
        //if magicians level is 0 then monsters level is 1
        if (currentLevel < 1) {
            return 1;
        } else if (currentLevel == 1) {
            //if magicians level is 1 then monsters level is 1 or 2
            return (int) (Math.random() * 2) + 1; // Generates 1 or 2
        }

        int randomInt = (int) (Math.random() * 3) - 1; // Generates -1, 0, or 1
        int newLevel = currentLevel + randomInt;
        
        return newLevel;
    }
}
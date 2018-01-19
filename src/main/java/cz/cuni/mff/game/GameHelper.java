/*
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation.
 */
package cz.cuni.mff.game;
import cz.cuni.mff.models.Card;
import java.util.ArrayList;
import java.util.Random;


/**
 * Contains functionality for starting, ending and generating the game
 */
public class GameHelper
{
    /**
     * Selects random item from ArrayList
     * @param list ArrayList of Cards from which random item should be selected
     * @return Card Random card from the list (deck)
     * TODO: Inspect this for enough randomness and distribution (it is not great at the moment)
     */
    public static Card randomArrayListItem(ArrayList<Card> list)
    {
        final Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static int getRandomInteger(int bound)
    {
        final Random rand = new Random();
        return rand.nextInt(bound);
    }

    // Following method shall not be present in final code as it was only "keyboard" helper when no UI was implemented
    public static int convertASCIIToInt(int ascii)
    {
        return ascii-48;    // 48 is ASCII number offset, which could have been a constant if it was not a temporary method
    }
}

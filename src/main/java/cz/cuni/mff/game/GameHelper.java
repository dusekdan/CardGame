package cz.cuni.mff.game;

import cz.cuni.mff.models.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */

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
    private static Random rand;
    public static Card randomArrayListItem(ArrayList<Card> list)
    {
        rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

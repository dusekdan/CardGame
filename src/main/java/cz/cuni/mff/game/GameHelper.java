package cz.cuni.mff.game;

import cz.cuni.mff.models.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
// Contains functionality for starting, ending and generating the game
public class GameHelper
{


    private static Random rand;
    public static Card randomArrayListItem(ArrayList<Card> list)
    {
        rand = new Random();        // TO-INSPECT: Randomness of this approach is at least questionable
        Card card = list.get(rand.nextInt(list.size()));
        return card;
    }

//    public static ArrayList<Card> prepareDeck()
//    {
//       ArrayList<Card> deck = new ArrayList<Card>();
//
//
//
//        // TODO: Use CardFactory pattern
//        // TODO: Use SpecialEffectFactory pattern
//
//        return deck;
//    }


}

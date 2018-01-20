/*
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation.
 */
package cz.cuni.mff.models;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public int size()
    {
        return deck.size();
    }

    public Card getCard(int index)
    {
        return deck.get(index);
    }

    public void addCard(Card card)
    {
        deck.add(card);
    }

    public void addCard(Card card, int index)
    {
        deck.add(index, card);
    }

    public Card removeCard(int index)
    {
        return deck.remove(index);
    }

    public Card removeCardFromBack()
    {
        return deck.remove(deck.size() - 1);
    }

    public Card removeCardFromTop()
    {
        return deck.remove(0);
    }
}

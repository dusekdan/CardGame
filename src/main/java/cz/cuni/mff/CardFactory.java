package cz.cuni.mff;

import cz.cuni.mff.models.*;

import java.util.ArrayList;

/**
 * Created by David Riha on 5.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class CardFactory
{
    private static final CardFactory instance = new CardFactory();

    private static ArrayList<Card> cards = new ArrayList<Card>();


    private CardFactory() {}


    public static CardFactory getInstance() { return instance; }


    public void createMinionCard(String name, String description, int cost, SpecialEffect effect, int health, int attack, MinionTypes minionType)
    {
        MinionCard card = new MinionCard(name, description, cost, effect, health, attack, minionType);

        cards.add(card);

    }


    public void createSpellCard(String name, String description, int cost, SpecialEffect effect)
    {
        SpellCard card = new SpellCard(name, description, cost, effect);
        cards.add(card);
    }


    public ArrayList<Card> getAllCards()
    {
        return cards;
    }
}

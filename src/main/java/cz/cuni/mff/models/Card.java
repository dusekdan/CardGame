package cz.cuni.mff.models;

/**
 * Created by - on 4.7.2017.
 */
// TODO: Consider making this abstract and side effects of such action
public class Card {

    public static final int CARD_DEFAULT_MANA_COST = 300;
    public static final String CARD_EMPTY_NAME = "Undefined";

    public int manaCost = CARD_DEFAULT_MANA_COST;
    public String cardName = CARD_EMPTY_NAME;

    public String getCardName()
    {
        return this.cardName;
    }

}

package cz.cuni.mff.models;


/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
// TODO: Consider making this abstract and side effects of such action
public class Card implements java.io.Serializable
{

    /**
     *  General card properties
     */
    private CardTypes type;
    private String name;
    private String description;
    private int cost;
    private SpecialEffect effect;


    /**
     * Constructs basic card instance from provided parameters
     * @param type CardTypes Enum type of card, can be either MINION_CARD or SPELL_CARD
     * @param name String Card name, displayed at the top of the card
     * @param description String Card description, when card has effect, card description is not displayed
     * @param cost Integer mana cost for card to be played
     * @param effect SpecialEffect Effect the card has when played / destroyed / triggered in other way
     */
    public Card(CardTypes type, String name, String description, int cost, SpecialEffect effect)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.effect = effect;
    }

    /**
     *  Card property getters
     */
    public String getCardName()
    {
        return this.name;
    }

    public int getManaCost()
    {
        return this.cost;
    }

    public String getDescription() { return this.description; }

    public CardTypes getType() { return type; }
}

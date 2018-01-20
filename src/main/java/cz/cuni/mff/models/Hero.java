/*
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation.
 */
package cz.cuni.mff.models;
import java.util.ArrayList;

public class Hero
{
    /**
     * Generally useful hero class constants
     */
    private static final int STARTING_HEALTH = 30;
    private static final int STARTING_ARMOR = 0;
    private static final int STARTING_CRYSTALS = 0;

    /**
     * General Hero properties
     */
    private String name;
    private int health;
    private int armor;
    private int mana;
    private int crystals;
    private boolean player;
    private Deck deck;

    /**
     * Current game-state properties
     */
    private ArrayList<Card> hand = new  ArrayList<>();
    private boolean defeated = false;
    private int lastFatigueDamage = 0;


    /**
     * Constructs hero
     * @param name String Hero name
     * @param isPlayer Boolean Player identification flag
     */
    public Hero(String name, boolean isPlayer)
    {
        // Set values received from constructor
        this.name = name;
        this.player = isPlayer;

        // Set other hero-basic values
        this.health = STARTING_HEALTH;
        this.armor = STARTING_ARMOR;
        this.crystals = STARTING_CRYSTALS;
        this.mana = getCrystals();
    }


    /**
     * Adds card to heroes hand
     * @param card Card Card to be added to hero's hand
     */
    public void putCardToHand(Card card)
    {
        hand.add(card);
    }

    /**
     * Removes card from hand and fills the gap in hand.
     * @param index Integer index of card to be removed from hand.
     * @return Card removed card.
     */
    public Card removeFromHand(int index)
    {
        System.out.println("Removin " + getHand().get(index).getCardName());
        return getHand().remove(index);
    }


    /**
     * Draws card from hero's deck
     */
    public void drawCard()
    {
        if (deck.size() >= 1)
        {
            // Remove the last one and remember forever that we draw decks from
            // the end, virtually.
            Card card = deck.removeCardFromTop();

            if (hand.size() < 10)
            {
                putCardToHand(card);
                System.out.println("Player " + getName() + " drew " + card.getCardName());
            }
            else
            {
                System.out.println("Player " + getName() + " drew " + card.getCardName() + " but his hand was full, so it burned down. Like your house. After those lemons.");
            }
        }
        else
        {
            executeFatigue();
        }

        System.out.println("Current player deck size: " + deck.size());
        System.out.println("Current hero hand size:" + getHand().size());
    }

    public void redrawCards(Integer card1, Integer card2, Integer card3, Integer card4)
    {
        // First remove cards from hand, order matters, cards under higher indexes must be removed first
        // so the array list order is not changed.
        if (card4 != null) {
            deck.addCard(removeFromHand(3));
        }

        if (card3 != null) {
            deck.addCard(removeFromHand(2));
        }

        if (card2 != null) {
            deck.addCard(removeFromHand(1));
        }

        if (card1 != null) {
            deck.addCard(removeFromHand(0));
        }

        // Then redraw
        if (card1 != null) {
            drawCard();
        }

        if (card2 != null) {
            drawCard();
        }

        if (card3 != null) {
            drawCard();
        }

        if (card4 != null) {
            drawCard();
        }
    }

    /**
     * Call Hero class method that will damage hero accordingly
     */
    private void executeFatigue()
    {
        System.out.println("[NO CARDS LEFT IN DECK - FATIGUE DAMAGE]");
        decreaseHealthByFatigue();
    }


    /**
     * Decreases hero health points by value
     * @param value Integer number of health points to be reduced
     */
    public void decreaseHealthBy(int value)
    {
        this.setHealth(getHealth() - value);

        // TODO: If we enable logic that will save hero somehow on 0 and less HP, exception check will come here
        if (getHealth() <= 0)
        {
            defeated = true;
        }
    }


    /**
     * Increases hero health points by value (complementary method to decreaseHealthBy)
     * @param value Integer number of health points to be added
     * TODO: Resolve case with adding more HP than is maximum (30), introduce maximum Hero HP constant
     */
    public void increaseHealthby(int value)
    {
        this.setHealth(getHealth() + value);
    }


    /**
     * Does fatigue damage to hero
     */
    public void decreaseHealthByFatigue()
    {
        lastFatigueDamage++;
        this.decreaseHealthBy(lastFatigueDamage);
    }


    /**
     * Getters & setters for general hero properties
     */
    public int getHealth() { return health; }
    private void setHealth(int value)
    {
        this.health = value;
    }

    public String getName() {
        return name;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public ArrayList<Card> getHand() { return this.hand; }

    public int getArmor() { return armor; }

    public int getMana() { return mana; }

    public int getCrystals() { return crystals; }

    public boolean isPlayer() { return player; }

    public Deck getDeck()
    {
        return deck;
    }

    public void setDeck(Deck deck)
    {
        this.deck = deck;
    }
}

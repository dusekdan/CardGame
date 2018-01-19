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
     */
    public void removeFromHand(int index)
    {
        getHand().remove(index);
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
}

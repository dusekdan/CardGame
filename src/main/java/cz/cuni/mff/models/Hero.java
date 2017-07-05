package cz.cuni.mff.models;

import java.util.ArrayList;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class Hero
{
    private String name;

    private int health;
    private int armor;
    private int mana;
    private int crystals;
    private boolean player;

    private ArrayList<Card> hand = new  ArrayList<Card>();


    public int getHealth() { return health; }

    public int getArmor() { return armor; }

    public int getMana() { return mana; }

    public int getCrystals() { return crystals; }

    public boolean isPlayer() { return player; }

    public Hero(String name, boolean isPlayer)
    {
        this.name = name;
        this.player = isPlayer;

        this.health = 30;
        this.armor = 0;
        this.crystals = 0;
        this.mana = getCrystals();
    }


    public String getName() {
        return name;
    }
}

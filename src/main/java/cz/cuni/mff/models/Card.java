package cz.cuni.mff.models;

import com.sun.deploy.panel.SpecialTreeListener;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
// TODO: Consider making this abstract and side effects of such action
public class Card implements java.io.Serializable {
    private static final int CARD_DEFAULT_MANA_COST = 666;
    private static final String CARD_EMPTY_NAME = "Undefined";


    private CardTypes type;
    private String name;
    private String description;
    private int cost;
    private SpecialEffect effect;



    public Card(CardTypes type, String name, String description, int cost, SpecialEffect effect)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.effect = effect;
    }



    private SpecialEffect specialEffect;





    public String getCardName()
    {
        return this.name;
    }

    public int getManaCost()
    {
        return this.cost;
    }

    public String getDescription() { return this.description; }

}

package cz.cuni.mff.models;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by - on 4.7.2017.
 */
// TODO: Consider making this abstract and side effects of such action
public class Card {

    public static final int CARD_DEFAULT_MANA_COST = 666;
    public static final String CARD_EMPTY_NAME = "Undefined";

    public int manaCost = CARD_DEFAULT_MANA_COST;
    public String cardName = CARD_EMPTY_NAME;

    private SpecialEffect specialEffect;

    public String getCardName()
    {
        return this.cardName;
    }

    public String getCardDescription()
    {
        return this.specialEffect.getDescription();
    }

    public int getManaCost()
    {
        return this.manaCost;
    }



    // Should represent special effect on card (the text in empty box bellow picture)
    private class SpecialEffect
    {
        public String description = "Effect description";

        public void applySpecialEffect(int target)  // will be slot identification?
        {
            throw new NotImplementedException();
        }

        public void reverseSpecialEffect(int target)
        {
            throw new NotImplementedException();
        }

        public String getDescription()
        {
            return this.description;
        }

        // TODO: Define special effect of card

        // "target type" -> any hero / friendly hero / enemy hero / any minion / enemy minion / friendly minion / all / all except heroes
        // "effect type" -> battlecry / deathrattle / ... let's not make this complicated
        // -- based on target type & effect type either boost the target immediately (with considering possible buff removal on minion death)

        // "description"
    }
}

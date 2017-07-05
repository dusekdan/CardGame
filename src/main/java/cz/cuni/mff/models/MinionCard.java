package cz.cuni.mff.models;

import cz.cuni.mff.game.LocalizationHelper;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class MinionCard extends Card
{
    private int health;
    private int attack;

    private MinionTypes minionType;

    private boolean readyToAttack = false;
    private boolean isTaunt = false;



    public MinionCard(String name, String description, int cost, SpecialEffect effect, int health, int attack, MinionTypes minionType)
    {
        // Fill general card properties
        super(CardTypes.MINION_CARD, name, description, cost, effect);

        // Fill spell-card specific properties
        this.health = health;
        this.attack = attack;
        this.minionType = minionType;

        // Ensure minion types are initialized properly
        // Only one type per minion is allowed (for now)
        switch(minionType)
        {
            case CHARGE:
                this.readyToAttack = true;
                break;
            case TAUNT:
                this.isTaunt = true;
                break;
        }

        logMinionCardInfo();
    }


    private void logMinionCardInfo()
    {
        System.out.println("+----------CARD----------+");
        System.out.println("|                        |");
        System.out.println(" Name: " + getCardName());
        System.out.println(" Cost: " + getManaCost());
        System.out.println(" Health: " + getHealth());
        System.out.println(" Attack: " + getAttack() + " (ready:" + isReadyToAttack()+")");
        System.out.println(" Minion Type: " + LocalizationHelper.getMinionTypeName(minionType));
        System.out.println(" Is taunt: " + isTaunt);
        System.out.println(" Description: ");
        System.out.println(" " + getDescription());
        System.out.println("|                        |");
        System.out.println("+------------------------+");
    }


    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isReadyToAttack() {
        return readyToAttack;
    }
}

package cz.cuni.mff.models;

/**
 * Created by - on 4.7.2017.
 */
public class SpellCard extends Card {

    public SpellCard(String name, String description, int cost, SpecialEffect effect)
    {
        // Fill general card properties
        super(CardTypes.SPELL_CARD, name, description, cost, effect);

        // Fill spell-card specific properties

        logSpellCardInfo();

    }

    private void logSpellCardInfo()
    {
        System.out.println("+----------CARD----------+");
        System.out.println("|                        |");
        System.out.println(" Name: " + getCardName());
        System.out.println(" Cost: " + getManaCost());
        System.out.println(" Description: ");
        System.out.println(getDescription());
        System.out.println("|                        |");
        System.out.println("+------------------------+");
    }
}

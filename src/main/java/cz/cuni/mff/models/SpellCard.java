package cz.cuni.mff.models;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class SpellCard extends Card {

    /**
     * Constructs spell card specialization
     * @param name String Card name
     * @param description String Card description, not displayed when special effect present
     * @param cost Integer Mana cost for card to be played
     * @param effect SpecialEffect Effect that card has
     */
    public SpellCard(String name, String description, int cost, SpecialEffect effect)
    {
        // Fill general card properties
        super(CardTypes.SPELL_CARD, name, description, cost, effect);

        // Fill spell-card specific properties

        // Log info card to console
        logSpellCardInfo();
    }

    /**
     * Logs information about card that the instance represents
     */
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

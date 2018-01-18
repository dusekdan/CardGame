package cz.cuni.mff;/*
 * Created by - on 18.1.2018.
 *
 * SIN Project 2017 - Intelligent Building Simulation
 * Faculty of Information Technology, Brno University of Technology
 */

import cz.cuni.mff.models.Card;
import cz.cuni.mff.models.MinionTypes;
import cz.cuni.mff.models.SpecialEffect;

import java.util.HashMap;
import java.util.Map;

final public class CardRegistry
{
    //private ArrayList<Card> minionCards = new ArrayList<>();
    //private ArrayList<Card> spellCards = new ArrayList<>();

    private static Map<String, Card> minions;
    private static Map<String, Card> spells;

    private CardRegistry() { }

    public static Card getMinionCard(String name)
    {
        if (minions == null)
            populateMinionRegistry();

        Card minion = minions.get(name);
        if (minion != null)
            return minion;
        else
            throw new NullPointerException();
    }

    public static Card getSpellCard(String name)
    {
        if (spells == null)
            populateSpellRegistry();

        Card spell = spells.get(name);
        if (spell != null)
            return spell;
        else
            throw new NullPointerException();
    }

    private static void populateMinionRegistry()
    {
        // Prepare card instances -> using cardFactory
        CardFactory cardFactory = new CardFactory();

        minions = new HashMap<>();
        minions.put("Ogre Magi",
            cardFactory.createMinionCard("Ogre Magi", "Intelect based troll with two heads.", 4, new SpecialEffect(), 4, 2, MinionTypes.REGULAR));
        minions.put("Bloodfen raptor",
            cardFactory.createMinionCard("Bloodfen raptor", "", 2, new SpecialEffect(), 3, 2, MinionTypes.REGULAR));
        minions.put("Abomination",
            cardFactory.createMinionCard("Abomination", "", 5, new SpecialEffect(), 4, 4, MinionTypes.TAUNT));
        minions.put("Bluegill Warrior",
            cardFactory.createMinionCard("Bluegill Warrior", "", 2, new SpecialEffect(), 2, 1, MinionTypes.CHARGE));
        minions.put("Wisp",
            cardFactory.createMinionCard("Wisp", "", 0, new SpecialEffect(), 1, 1, MinionTypes.REGULAR));
        minions.put("Elven Archer",
            cardFactory.createMinionCard("Elven Archer", "Battlecry: Deal 1 damage.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR));
        // TODO: To be continued.
    }

    private static void populateSpellRegistry()
    {
        // Prepare card instance -> using cardFactory
        CardFactory cardFactory = new CardFactory();

        spells = new HashMap<>();
        spells.put("Flamestrike", cardFactory.createSpellCard("Flamestrike", "Deal 4 damage to all \n enemy minions.", 7, new SpecialEffect()));
        spells.put("Hellfire", cardFactory.createSpellCard("Hellfire", "Deal 3 damage to everyone.", 4, new SpecialEffect()));
        spells.put("Flare", cardFactory.createSpellCard("Flare", "All minions \nlose Stealth. Destroy all\nenemy Secrets. Draw a\ncard.", 2, new SpecialEffect()));
        spells.put("Arcane Explosion", cardFactory.createSpellCard("Arcane Explosion", "Deal 1 damage to all \n enemy minions.", 2, new SpecialEffect()));
        // TODO: To be continued.
    }
}

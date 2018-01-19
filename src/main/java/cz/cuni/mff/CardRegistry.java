package cz.cuni.mff;/*
 * Created by - on 18.1.2018.
 *
 * SIN Project 2017 - Intelligent Building Simulation
 * Faculty of Information Technology, Brno University of Technology
 */

import cz.cuni.mff.game.GameHelper;
import cz.cuni.mff.models.Card;
import cz.cuni.mff.models.MinionTypes;
import cz.cuni.mff.models.SpecialEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final public class CardRegistry
{
    private static Map<String, Card> minions;
    private static Map<String, Card> spells;

    private static CardFactory cardFactory;

    private CardRegistry() { }

    /*
     * Populate minions and spells collections.
     */
    static {
        if (cardFactory == null)
            cardFactory = new CardFactory();

        if (minions == null)
            populateMinionRegistry();

        if (spells == null)
            populateSpellRegistry();
    }

    /**
     * Empty implementation of public method allows to force execution
     * of static initializer at specific time. This will be most likely
     * done on application startup.
     */
    public static void init(){}

    /**
     * Returns clone of minion card prototype by name.
     * @param name String minion identifier.
     * @return MinionCard Unique instance representing minion with given name.
     */
    public static Card getMinionCard(String name)
    {
        Card minion = minions.get(name);
        if (minion != null)
            return minion.cloneCard();
        else
            throw new NullPointerException();
    }

    /**
     * Returns clone of spell card prototype by name.
     * @param name String spell identifier.
     * @return SpellCard Unique instance representing spell with given name.
     */
    public static Card getSpellCard(String name)
    {
        Card spell = spells.get(name);
        if (spell != null)
            return spell.cloneCard();
        else
            throw new NullPointerException();
    }

    /**
     * Retrieves random spell card.
     * @return SpellCard Randomly selected card form all spell cards universe.
     */
    public static Card getRandomSpellCard()
    {
        int spellsSize = spells.size();
        ArrayList<String> keys = new ArrayList<>(spells.keySet());
        int randomSpell = GameHelper.getRandomInteger(spellsSize);

        return spells.get(keys.get(randomSpell)).cloneCard();
    }

    /**
     * Retrieves random minion card.
     * @return SpellCard Randomly selected card form all minion cards universe.
     */
    public static Card getRandomMinionCard()
    {
        int minionsSize = minions.size();
        ArrayList<String> keys = new ArrayList<>(minions.keySet());
        int randomMinion = GameHelper.getRandomInteger(minionsSize);

        return minions.get(keys.get(randomMinion)).cloneCard();
    }

    /**
     * Populates registry with prototype MinionCard instances.
     */
    private static void populateMinionRegistry()
    {
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
        minions.put("Abusive Sergeant",
                cardFactory.createMinionCard("Abusive Sergeant", "Battlecry: Give a minion +2 attack this turn.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR));
        minions.put("Emerald Reaver",
                cardFactory.createMinionCard("Emerald Reaver", "Battlecry: Deal 1 damage to each hero.", 1, new SpecialEffect(), 2, 1, MinionTypes.REGULAR));
        minions.put("Fire Fly",
                cardFactory.createMinionCard("Fire Fly", "Battlecry: Add a 1/2 minion to your hand.", 1, new SpecialEffect(), 1, 2, MinionTypes.REGULAR));
        minions.put("Goldshire Footman",
                cardFactory.createMinionCard("Goldshire Footman", "Taunt", 1, new SpecialEffect(), 1, 2, MinionTypes.TAUNT));
        minions.put("Mistress of Mixtures",
                cardFactory.createMinionCard("Mistress of Mixtures", "Deathrattle: Restore 4 health to each hero.", 1, new SpecialEffect(), 2, 2, MinionTypes.REGULAR));
        minions.put("Leper Gnome",
                cardFactory.createMinionCard("Leper Gnome", "Deathrattle: Deal 2 damage to the enemy hero.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR));
        minions.put("Stonetusk Boar",
                cardFactory.createMinionCard("Stonetusk Boar", "Charge", 1, new SpecialEffect(), 1, 2, MinionTypes.CHARGE));
        minions.put("Crazed Alchemist",
                cardFactory.createMinionCard("Crazed Alchemist", "Battlecry: Swap attack and health of a minion.", 2, new SpecialEffect(), 2, 2, MinionTypes.REGULAR));
        minions.put("Duskboar",
                cardFactory.createMinionCard("Duskboar", "", 2, new SpecialEffect(), 4, 1, MinionTypes.REGULAR));
        minions.put("Frostwolf grunt",
                cardFactory.createMinionCard("Frostwolf grunt", "Taunt", 2, new SpecialEffect(), 2, 2, MinionTypes.TAUNT));
        minions.put("Loot Hoarder",
                cardFactory.createMinionCard("Loot Hoarder", "Deathrattle: Draw a card.", 2, new SpecialEffect(), 2, 1, MinionTypes.REGULAR));
        minions.put("Mana Wraith",
                cardFactory.createMinionCard("Mana Wraith", "ALL minions cost 1 more.", 2, new SpecialEffect(), 2, 2, MinionTypes.REGULAR));
        minions.put("Novice Engineer",
                cardFactory.createMinionCard("Novice Engineer", "Battlecry: Draw a card.", 2, new SpecialEffect(), 1, 1, MinionTypes.REGULAR));
        minions.put("River Crocolisk",
                cardFactory.createMinionCard("River Crocolisk", "", 2, new SpecialEffect(), 2, 3, MinionTypes.REGULAR));
        minions.put("Sunfury Protector",
                cardFactory.createMinionCard("Sunfury Protector", "Battlecry: Give adjacent \n minions Taunt.", 2, new SpecialEffect(), 2, 3, MinionTypes.REGULAR));
        minions.put("Stonetusk Boar",
                cardFactory.createMinionCard("Stonetusk Boar", "Charge", 1, new SpecialEffect(), 1, 2, MinionTypes.REGULAR));
        minions.put("Arcane Golem",
                cardFactory.createMinionCard("Arcane Golem", "Battlecry: Give your  \n opponent a Mana crystal", 2, new SpecialEffect(), 4, 4, MinionTypes.REGULAR));
        minions.put("Am'gam Rager",
                cardFactory.createMinionCard("Am'gam Rager", "", 2, new SpecialEffect(), 1, 5, MinionTypes.REGULAR));
        minions.put("Coldlight Oracle",
                cardFactory.createMinionCard("Coldlight Oracle", "Battlecry: Each player \n draws 2 cards.", 3, new SpecialEffect(), 2, 2, MinionTypes.REGULAR));
        minions.put("Hired Gun",
                cardFactory.createMinionCard("Hired Gun", "Taunt", 3, new SpecialEffect(), 4, 3, MinionTypes.TAUNT));
        minions.put("Magma Rager",
                cardFactory.createMinionCard("Magma Rager", "", 3, new SpecialEffect(), 5, 1, MinionTypes.REGULAR));
        minions.put("Raid Leader",
                cardFactory.createMinionCard("Raid Leader", "Your other minions have \n +1 attack.", 3, new SpecialEffect(), 2, 2, MinionTypes.REGULAR));
        minions.put("Shattered Sun Cleric",
                cardFactory.createMinionCard("Shattered Sun Cleric", "Battlecry: Give a friendly minion +1/+1.", 3, new SpecialEffect(), 3, 2, MinionTypes.REGULAR));
        minions.put("Wolfrider",
                cardFactory.createMinionCard("Wolfrider", "Charge", 3, new SpecialEffect(), 3, 1, MinionTypes.CHARGE));
        minions.put("Chillwind Yeti",
                cardFactory.createMinionCard("Chillwind Yeti", "", 4, new SpecialEffect(), 4, 5, MinionTypes.REGULAR));
        minions.put("Fire Plume Phoenix",
                cardFactory.createMinionCard("Fire Plume Phoenix", "Battlecry: Deal 2 damage.", 4, new SpecialEffect(), 3, 3, MinionTypes.REGULAR));
        minions.put("Gnomish Inventor",
                cardFactory.createMinionCard("Gnomish Inventor", "Battlecry: Draw a card.", 4, new SpecialEffect(), 2, 4, MinionTypes.REGULAR));
        minions.put("Oasis Snapjaw",
                cardFactory.createMinionCard("Oasis Snapjaw", "", 4, new SpecialEffect(), 2, 7, MinionTypes.REGULAR));
        minions.put("Sen'jin Shieldmasta",
                cardFactory.createMinionCard("Sen'jin Shieldmasta", "Taunt", 4, new SpecialEffect(), 3, 5, MinionTypes.TAUNT));
        minions.put("Stormwind Knight",
                cardFactory.createMinionCard("Stormwind Knight", "Charge", 4, new SpecialEffect(), 2, 5, MinionTypes.CHARGE));
        minions.put("Darkscale Healer",
                cardFactory.createMinionCard("Darkscale Healer", "Battlecry: Restore 2 health to all friendly characters.", 5, new SpecialEffect(), 4, 5, MinionTypes.REGULAR));
        minions.put("Stormpike Commando",
                cardFactory.createMinionCard("Stormpike Commando", "Battlecry: Deal 2 damage.", 5, new SpecialEffect(), 4, 2, MinionTypes.REGULAR));
        minions.put("Ancient of Blossoms",
                cardFactory.createMinionCard("Ancient of Blossoms", "Taunt", 6, new SpecialEffect(), 3, 8, MinionTypes.TAUNT));
        minions.put("Boulderfist Ogre",
                cardFactory.createMinionCard("Boulderfist Ogre", "", 6, new SpecialEffect(), 6, 7, MinionTypes.REGULAR));
        minions.put("Reckless Rocketeer",
                cardFactory.createMinionCard("Reckless Rocketeer", "Charge", 6, new SpecialEffect(), 5, 2, MinionTypes.CHARGE));
        minions.put("Bog Creeper",
                cardFactory.createMinionCard("Bog Creeper", "Taunt", 7, new SpecialEffect(), 6, 8, MinionTypes.REGULAR));
        minions.put("War Golem",
                cardFactory.createMinionCard("War Golem", "", 7, new SpecialEffect(), 7, 7, MinionTypes.REGULAR));
        minions.put("Alexstraza",
                cardFactory.createMinionCard("Alexstraza", "Battlecry: Set a hero's remaining health to 15.", 8, new SpecialEffect(), 8, 8, MinionTypes.REGULAR));
        minions.put("Sea Giant",
                cardFactory.createMinionCard("Sea Giant", "Cost 1 less for each other minion on the battlefield", 10, new SpecialEffect(), 8, 8, MinionTypes.REGULAR));
    }

    /**
     * Populates registry with SpellCard instances.
     */
    private static void populateSpellRegistry()
    {
        spells = new HashMap<>();
        spells.put("Flamestrike",
                cardFactory.createSpellCard("Flamestrike", "Deal 4 damage to all \n enemy minions.", 7, new SpecialEffect()));
        spells.put("Hellfire",
                cardFactory.createSpellCard("Hellfire", "Deal 3 damage to everyone.", 4, new SpecialEffect()));
        spells.put("Flare",
                cardFactory.createSpellCard("Flare", "All minions \nlose Stealth. Destroy all\nenemy Secrets. Draw a\ncard.", 2, new SpecialEffect()));
        spells.put("Arcane Explosion",
                cardFactory.createSpellCard("Arcane Explosion", "Deal 1 damage to all \n enemy minions.", 2, new SpecialEffect()));
        spells.put("Arcane Intellect",
                cardFactory.createSpellCard("Arcane Intellect", "Draw 2 cards.", 3, new SpecialEffect()));
        spells.put("Fireball",
                cardFactory.createSpellCard("Fireball", "Deal 6 damage.", 4, new SpecialEffect()));
        spells.put("Power Word: Shield",
                cardFactory.createSpellCard("Power Word: Shield", "Give a minion \n +2 health. \n Draw a card.", 1, new SpecialEffect()));
        spells.put("Shadow Word: Pain",
                cardFactory.createSpellCard("Shadow Word: Pain", "Destroy a minion with 3 or less attack.", 2, new SpecialEffect()));
        spells.put("Shadow Word: Death",
                cardFactory.createSpellCard("Shadow Word: Death", "Destroy a minion with 5 or more attack.", 3, new SpecialEffect()));
        spells.put("Bloodlust",
                cardFactory.createSpellCard("Bloodlust", "Give your minions +3 attack this turn", 5, new SpecialEffect()));
        spells.put("Assassinate",
                cardFactory.createSpellCard("Assassinate", "Destroy an enemy minion.", 5, new SpecialEffect()));
        spells.put("Hunter's Mark",
                cardFactory.createSpellCard("Hunter's Mark", "Change a minion's \n health to 1.", 1, new SpecialEffect()));
    }
}

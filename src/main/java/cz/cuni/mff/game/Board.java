package cz.cuni.mff.game;

import cz.cuni.mff.CardFactory;
import cz.cuni.mff.models.*;
import helpers.ObjectCloner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class Board{

    /**
     * Class constants for generally useful magic numbers
     */
    private static final int MAX_SLOT_INDEX = 7;
    private static final int DECK_SIZE = 30;

    /**
     * Two players are represented by two Hero instances
     * It is expected for one instance to always be a computer
     */
    private Hero player;
    private Hero computer;

    /**
     * Each side of the game board has slots for cards (7 in total each)
     * These are represented as associative arrays created with HashMap & Map
     */
    private Map<Integer, Card> playerSlots = new HashMap<Integer, Card>();
    private Map<Integer, Card> computerSlots = new HashMap<Integer, Card>();

    /**
     * Each hero has its own ArrayList of cards that starts with
     * 30 cards (generated via prepareDecks) and are reduced with
     * each draw (drawCard)
     */
    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private ArrayList<Card> computerDeck = new ArrayList<Card>();


    /**
     *  Prepares both player's and computer's card deck
     *  Cards are put together randomly
     *  Possible TODO: Rules for random pack generation
     */
    public void prepareDecks()
    {
        // Get cards from factory
        ArrayList<Card> cardPool = CardFactory.getInstance().getAllCards();

        Card pickedPlayer;
        Card pickedComputer;
        for (int i = 0; i < DECK_SIZE; i++)
        {
            // Pick random card instance and clone it to playerDeck, repeat the process for computerDeck
            pickedPlayer = GameHelper.randomArrayListItem(cardPool);
            pickedComputer = GameHelper.randomArrayListItem(cardPool);

            try
            {
                playerDeck.add(
                        (Card) ObjectCloner.deepCopy(pickedPlayer)
                );
                computerDeck.add(
                        (Card) ObjectCloner.deepCopy(pickedComputer)
                );
            }
            catch (Exception e)
            {
                System.out.println("Unable to clone object, message: " + e.getMessage());
            }

        }
    }


    /**
     * Debug method for showing contents of both player and computer decks
     */
    private void showDecks()
    {
        System.out.println("=======SHOWING DECK=========");
        for (int i = 0; i < playerDeck.size(); i++)
        {
            System.out.println("(Player, Computer): (" + playerDeck.get(i).getCardName() + ", " + computerDeck.get(i).getCardName() + ")");
            System.out.println("Object ID: " + playerDeck.get(i) + ", " + computerDeck.get(i));
        }
    }


    /**
     * Draws card from corresponding deck
     * @param hero Hero Identification of 'side' to draw card
     * TODO: Burn card when there are 10 cards in hand already
     */
    public void drawCard(Hero hero)
    {
        ArrayList<Card> deck = hero.isPlayer() ? playerDeck : computerDeck;

        if (deck.size() >= 1)
        {
            // Remove the last one and remember forever that we draw decks from
            // the end, virtually.
            Card card = deck.remove(deck.size()-1);
            hero.putCardToHand(card);

            // Report what happened
            System.out.println("Player " + hero.getName() + " draw " + card.getCardName());
        }
        else
        {
            executeFatigue(hero);
        }

        System.out.println("Current player deck size: " + playerDeck.size());
        System.out.println("Current hero hand size:" + hero.getHand().size());
    }


    // Let's introduce convention here - LEFT is the computer side, RIGHT is the player side
    // One day, we will regret this. But that day is not today. Today we fight.
    /**
     * Places card into slot on the corresponding board side
     * @param slotNumber Integer identification of slot for the card to be placed in
     * @param side BoardSides Side of the board
     * @param card Card Card to be placed on board
     * @return Boolean true on card placement success
     * TODO: Reconsider how to properly handle determining what side is computer and what player (comment above)
     */
    public boolean placeCard(int slotNumber, BoardSides side, Card card)
    {
        if (slotNumber >= 0 && slotNumber < MAX_SLOT_INDEX)
        {
            System.out.println("Don't mind me, I'm just placing " + card.getCardName() + " to slot number " + slotNumber + " on " + LocalizationHelper.getBoardSideName(side) + " side of the board.");

            // For LEFT boardside insert to computer's slot
            if (side == BoardSides.LEFT)
            {
                computerSlots.put(slotNumber, card);
            }
            // RIGHT means players slot
            else
            {
                playerSlots.put(slotNumber, card);
            }

            return true;
        }
        else
        {
            System.out.println("Invalid slot number: " + slotNumber + " (maximum is " + MAX_SLOT_INDEX + ")");
            return false;
        }
    }


    /**
     * Remove card from the board
     * @param slotNumber Integer identification of slot from which we remove card
     * @param side BoardSides Side of the board
     * @return Boolean True on successful removal, False otherwise
     */
    public boolean removeCard(int slotNumber, BoardSides side)
    {
        if (slotNumber < MAX_SLOT_INDEX && slotNumber >= 0)
        {
            System.out.println("Don't mind me, I'm just removing card from slot number " + slotNumber + " on " + LocalizationHelper.getBoardSideName(side) + " side of the board.");

            if (side == BoardSides.LEFT)
            {
                computerSlots.remove(slotNumber);
            }
            else
            {
                playerSlots.remove(slotNumber);
            }

            return true;
        }
        else
        {
            System.out.println("Invalid slot number: " + slotNumber + " (maximum is " + MAX_SLOT_INDEX + ")");
            return false;
        }
    }


    /**
     * Call Hero class method that will damage hero accordingly
     * @param hero Hero Hero to be damaged.
     */
    private void executeFatigue(Hero hero)
    {
        System.out.println("[NO CARDS LEFT IN DECK - FATIGUE DAMAGE]");
        hero.decreaseHealthByFatigue();
    }


    /**
     * Returns True when conditions for game to end are met
     * @return Boolean True when the game is over.
     */
    public boolean isGameOver()
    {
        return (player.getHealth() <= 0 || computer.getHealth() <= 0);
    }


    /**
     * Adds hero to the game
     * @param hero Hero Hero to be added to the game.
     */
    public void putHero(Hero hero)
    {
        if (hero.isPlayer())
        {
            this.player = hero;
        }
        else
        {
            this.computer = hero;
        }

        logHeroEntrance(hero);
    }


    /**
     * Debug method that logs when hero 'enters' the game.
     * @param hero Hero Hero that has entered the game.
     */
    private void logHeroEntrance(Hero hero)
    {
        System.out.println("Hero " + hero.getName() + " entered the game (Player: " + hero.isPlayer() + ", Health: " + hero.getHealth() + ")");
    }


    /**
     * Replaces card in given slot on the given side of the board by another card.
     * @param slotNumber Integer identification of slot where card should be replaced
     * @param side BoardSides Identification of side
     * @param card Card Card that will replace original card in slot
     * TODO: To be implemented
     */
    public void replaceCard(int slotNumber, BoardSides side, Card card)
    {

    }
}



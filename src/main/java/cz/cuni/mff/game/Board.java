package cz.cuni.mff.game;

import cz.cuni.mff.CardFactory;
import cz.cuni.mff.models.*;
import helpers.ObjectCloner;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
interface IBoard
{
    boolean placeCard(int slotNumber, BoardSides side, Card card);


    void removeCard(int slotNumber, int side);
    void replaceCard(int slotNumber, int side);
}

public class Board implements IBoard {

    private static final int MAX_SLOT_INDEX = 7;

    public Hero player;
    public Hero computer;

    private Map<Integer, Card> playerSlots = new HashMap<Integer, Card>();
    private Map<Integer, Card> computerSlots = new HashMap<Integer, Card>();

    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private ArrayList<Card> computerDeck = new ArrayList<Card>();




    public void prepareDecks()
    {
        // Get cards from factory
        ArrayList<Card> cardPool = CardFactory.getInstance().getAllCards();

        // Generate random 30-items decks
        // TODO: Major room for improvement, especially considering game design, now it's random draft

        Card pickedPlayer;
        Card pickedComputer;
        for (int i = 0; i < 30; i++)
        {
            // Pick random card instance and clone it to playerDeck (do the same for computerDeck)
            pickedPlayer = GameHelper.randomArrayListItem(cardPool);
            pickedComputer = GameHelper.randomArrayListItem(cardPool);

            System.out.println("Randomly picked: " + pickedPlayer.getCardName());
            System.out.println("Object ID: " + pickedPlayer);

            // TODO: Warning - typecasting here could potentially lose some information
            // -- Karel Fajkus believes that it will be okay, thought. He's good in Java, he should know.
            try
            {
                /*if (pickedPlayer.getType() == CardTypes.SPELL_CARD)
                {
                     playerDeck.add(
                             (SpellCard) ObjectCloner.deepCopy(pickedPlayer)
                    );
                }
                else
                {
                     playerDeck.add(
                             (MinionCard) ObjectCloner.deepCopy(pickedPlayer)
                    );
                }*/

                playerDeck.add((Card) ObjectCloner.deepCopy(pickedPlayer));
                computerDeck.add((Card) ObjectCloner.deepCopy(pickedComputer));
            }
            catch (Exception e)
            {
                System.out.println("Unable to clone object, message: " + e.getMessage());
            }



            Card justAdded = playerDeck.get(playerDeck.size()-1);
            if (justAdded instanceof MinionCard)
            {
                System.out.println("This card is minion with health: " + ((MinionCard) justAdded).getHealth());
            }

        }

        showDecks();
    }

    private void showDecks()
    {
        System.out.println("=======SHOWING DECK=========");
        for (int i = 0; i < playerDeck.size(); i++)
        {
            System.out.println("(Player, Computer): (" + playerDeck.get(i).getCardName() + ", " + computerDeck.get(i).getCardName() + ")");
            System.out.println("Object ID: " + playerDeck.get(i) + ", " + computerDeck.get(i));
        }
    }



    /*private void shuffleDeck()
    {
        long seed = System.nanoTime();
        Collections.shuffle(deck)
    }*/

    // Let's introduce convention here - LEFT is the computer side, RIGHT is the player side
    // One day, we will regret this. But that day is not today. Today we fight.
    public boolean placeCard(int slotNumber, BoardSides side, Card card)
    {
        if (slotNumber < MAX_SLOT_INDEX && slotNumber >= 0)
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

    private void logHeroEntrance(Hero hero)
    {
        System.out.println("Hero " + hero.getName() + " entered the game (Player: " + hero.isPlayer() + ", Health: " + hero.getHealth() + ")");
    }




    /*public boolean placeCard(int slotNumber, int side, SpellCard card)
    {
        return false;
    }*/


    public void removeCard(int slotNumber, int side) {

    }


    public void replaceCard(int slotNumber, int side) {

    }


}



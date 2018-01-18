package cz.cuni.mff;

import cz.cuni.mff.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by David Riha on 5.7.2017.
 * Project: Simplified HearthStone java implementation
 */
@Service
public class CardFactory {

    /**
     * All possible cards are stored within the cards ArrayList
     */
    private static ArrayList<Card> cards = new ArrayList();


    /**
     * Creates minion card based of parameters provided
     * @param name String Minion name
     * @param description String Minion description, in collision with SpecialEffect description
     * @param cost Integer Mana cost to play the card
     * @param effect SpecialEffect Special effect assigned to the minion card
     * @param health Integer Number of health the minion have when created
     * @param attack Integer Number of HP removed when attacked by this minion
     * @param minionType MinionTypes Type of minion either taunt or charge or regular
     */
    public Card createMinionCard(String name, String description, int cost, SpecialEffect effect, int health, int attack, MinionTypes minionType)
    {
        return new MinionCard(name, description, cost, effect, health, attack, minionType);
        //cards.add(card);
    }


    /**
     * Creates spell based of parameteres provided
     * @param name String Card name
     * @param description String Card description, not displayed when special effect present
     * @param cost Integer Mana cost for card to be played
     * @param effect SpecialEffect Effect that card has
     */
    public Card createSpellCard(String name, String description, int cost, SpecialEffect effect)
    {
        return new SpellCard(name, description, cost, effect);
        //cards.add(card);
    }


    /**
     * Retrieves all possible cards created so far via createXXXCard methods
     * @return ArrayList<Card> List of cards
     */
    public ArrayList<Card> getAllCards()
    {
        return cards;
    }
}

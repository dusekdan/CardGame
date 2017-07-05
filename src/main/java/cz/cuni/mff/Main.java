package cz.cuni.mff;

import cz.cuni.mff.game.Board;
import cz.cuni.mff.models.*;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
// Launching the application via "Main" build configuration is only a temporary
// solution as we'll configure maven later on.
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Let's pretend we are launching the game.");

        launchGame();

        System.out.println("The game has ended or something");
    }

    private static void launchGame()
    {
        // Prepare cards that will be used
        prepareGameCards();     // TODO: Handle this in other place, differently (less statics)

        // Test card accessibility
        // This implies that our static implementation works as expected
        // System.out.println("Size of generated pack afterwards: " + CardFactory.getInstance().getAllCards().size());




        // Create board
        Board board = new Board();

        // Create two heroes
        Hero player = new Hero("FlexoCZ", true);
        Hero computer = new Hero("Anihilat0r", false);

        // Place heroes in the game
        board.putHero(player);
        board.putHero(computer);

        // Generate decks for players.
        board.prepareDecks();


        // Place both cards somewhere on the board
        //board.placeCard(0, BoardSides.LEFT, minion1);
        //board.placeCard(0, BoardSides.RIGHT, spell1);

    }

    // In real world, this would have been stored in some sort of a database
    // and cards and their stats would be pulled from it. This is not a real
    // world, but school projects, so we stick to loading them before game
    // is launched.
    private static void prepareGameCards()
    {
        // TODO: Handle SpecialEffect creation here as well so we can link them to cards
        // -- This logic will be possibly relocated to GameHelper before release.

        // Card creation
        CardFactory factory = CardFactory.getInstance();

        // Minion Cards
        factory.createMinionCard("Ogre Magi", "Intelect based troll with two heads.", 4, new SpecialEffect(), 4, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Bloodfen raptor", "", 2, new SpecialEffect(), 3, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Abomination", "", 5, new SpecialEffect(), 4, 4, MinionTypes.TAUNT);
        factory.createMinionCard("Bluegill Warrior", "", 2, new SpecialEffect(), 2, 1, MinionTypes.CHARGE);

        // Spell Cards
        factory.createSpellCard("Flamestrike", "Deal 4 damage to all \n enemy minions.", 7, new SpecialEffect());
        factory.createSpellCard("Hellfire", "Deal 3 damage to everyone.", 4, new SpecialEffect());
        factory.createSpellCard("Flare", "All minions \nlose Stealth. Destroy all\nenemy Secrets. Draw a\ncard.", 2, new SpecialEffect());

        System.out.println("Size of generated card pack is: " + factory.getAllCards().size());
    }
}

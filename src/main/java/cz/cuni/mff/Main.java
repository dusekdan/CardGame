/*
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation.
 */
package cz.cuni.mff;
import cz.cuni.mff.game.Board;
import cz.cuni.mff.game.GameHelper;
import cz.cuni.mff.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

// Launching the application via "Main" build configuration is only a temporary
// solution as we'll configure maven later on.
@SpringBootApplication
public class Main {

    @Autowired
    private CardFactory factory;

    @Autowired
    private Board board;

    public static void main(String[] args)
    {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        final Main mainObj = ctx.getBean(Main.class);

        System.out.println("Let's pretend we are launching the game.");
        mainObj.launchGame();

        System.out.println("The game has ended or something");
    }

    private void launchGame()
    {
        CardRegistry.init();    // Hit card registry on game launch, so card collections get populated

        // Create heroes and put them into the game
        Hero player = new Hero("FlexoCZ", true);
        Hero computer = new Hero("Anihilat0r", false);
        board.putHero(player);
        board.putHero(computer);

        // Generate decks for players.
        board.prepareRandomDecks();

        // Start the game loop
        // -- While both heroes health are greater than 0, loop
        while (!board.isGameOver())
        {
            int trash = -1; // To swallow end line in console

            System.out.println("Entering round: #" + board.getRound());

            if (board.isPlayerTurn())
            {

                if (board.getRound() == 1)
                {
                    // Get 3 cards and an option to change some of them
                    board.getPlayerHero().drawCard();
                    board.getPlayerHero().drawCard();
                    board.getPlayerHero().drawCard();

                    //  Offer exchange
                    //System.out.println("Card #0: " + board.getPlayerHero().getHand().get(0).getCardName());
                    //System.out.println("Card #1: " + board.getPlayerHero().getHand().get(1).getCardName());
                    //System.out.println("Card #2: " + board.getPlayerHero().getHand().get(2).getCardName());
                    //System.out.println("|=======| REDRAWING IN PROGRESS |=======|");
                    // Fake player's choice to change cards 1, 2 and keep the 3 (4 not offered for exchange)
                    board.getPlayerHero().redrawCards(1, 1, null, null);
                    //  Print redraw
                    //System.out.println("Card #0: " + board.getPlayerHero().getHand().get(0).getCardName());
                    //System.out.println("Card #1: " + board.getPlayerHero().getHand().get(1).getCardName());
                    //System.out.println("Card #2: " + board.getPlayerHero().getHand().get(2).getCardName());
                }

                // Player does his thing
                board.getPlayerHero().drawCard();

                // Read card number & slot number for placement
                int entry = 0;
                int slot = 0;
                try {
                    entry = GameHelper.convertASCIIToInt(System.in.read());
                    slot = GameHelper.convertASCIIToInt(System.in.read());

                    trash = System.in.read(); // Get rid of that enter
                } catch (IOException e) { System.out.println("Reading entry failed. God damn."); }

                // TODO: As every value gets decremented by 1 (cause of indexing) figure out the way to translate this more nicely
                System.out.println("Entry=" + entry + " Slot=" + slot);
                if (board.checkSlotFree(slot-1, BoardSides.RIGHT))
                {
                    board.placeCard(slot-1, BoardSides.RIGHT, board.getPlayerHero().getHand().get(entry-1));
                    board.getPlayerHero().removeFromHand(entry-1);
                }
                else
                {
                    // TODO: Probably do this in a loop until player chooses correctly (but since this is only a console demo, it doesnt matter that much)
                    System.out.println("You selected occupied slot. You won't get the chance to choose different slot, your bad.");
                }
            }
            else
            {
                // Computer does his thing
                board.getComputerHero().drawCard();
                // TODO: Implement computer strategy (pretty much just random card placement at the moment I guess)
            }
            board.endTurn();
        }

        // Retrieve game result
        // -- Winner
        // -- Number of rounds
        // -- What else?
        String winner = (player.isDefeated()) ? computer.getName() : player.getName();
        printGameResults(winner, board.getRound());

        // Place both cards somewhere on the board
        //board.placeCard(0, BoardSides.LEFT, minion1);
        //board.placeCard(0, BoardSides.RIGHT, spell1);

    }

    private void printGameResults(String winner, int roundsTotal)
    {
        System.out.println(" === THE GAME HAS ENDED ===");
        System.out.println(" And the winner is... ");
        System.out.println(" " + winner);
        System.out.println(" Rounds played: " + roundsTotal);
        System.out.println(" === SEE YOU NEXT TIME  ===");

    }
}

package cz.cuni.mff;

import cz.cuni.mff.game.Board;
import cz.cuni.mff.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
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
        // Prepare cards that will be used
        prepareGameCards();     // TODO: Handle this in other place, differently (less statics)

        // Test card accessibility
        // This implies that our static implementation works as expected
        // System.out.println("Size of generated pack afterwards: " + CardFactory.getInstance().getAllCards().size());

        // Create two heroes
        Hero player = new Hero("FlexoCZ", true);
        Hero computer = new Hero("Anihilat0r", false);

        // Place heroes in the game
        board.putHero(player);
        board.putHero(computer);

        // Generate decks for players.
        board.prepareDecks();

        // Game loop
        // -- While both heroes health are greater than 0, loop
        int round = 0;
        while (!board.isGameOver())
        {
            System.out.println("Entering round: #" + round);

            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println("Unable to sleep, so we're just gonna skip to another round.");
            }

            System.out.println("Leaving round: #" + round);

            round++;
            board.drawCard(player);
            board.drawCard(computer);

            /*
            System.out.println("Press enter to proceed to another round.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Something went south.");
            }
            */
        }

        // Retrieve game result
        // -- Winner
        // -- Number of rounds
        // -- What else?
        String winner = (player.isDefeated()) ? computer.getName() : player.getName();
        printGameResults(winner, round);

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

    // In real world, this would have been stored in some sort of a database
    // and cards and their stats would be pulled from it. This is not a real
    // world, but school projects, so we stick to loading them before game
    // is launched.
    private void prepareGameCards()
    {
        System.out.println("Size of generated card pack is: " + factory.getAllCards().size());
    }
}

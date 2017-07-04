package cz.cuni.mff;

import cz.cuni.mff.game.Board;
import cz.cuni.mff.models.BoardSides;
import cz.cuni.mff.models.MinionCard;
import cz.cuni.mff.models.SpellCard;

/**
 * Created by - on 4.7.2017.
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

        // Create board
        Board board = new Board();


        // Create random minion card
        MinionCard minion1 = new MinionCard();
        // Create random spell card
        SpellCard spell1 = new SpellCard();

        // Place both cards somewhere on the board
        board.placeCard(0, BoardSides.LEFT, minion1);
        board.placeCard(0, BoardSides.RIGHT, spell1);

    }
}

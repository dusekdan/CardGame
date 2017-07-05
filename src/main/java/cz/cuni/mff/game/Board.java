package cz.cuni.mff.game;

import cz.cuni.mff.models.*;

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

    public Hero player;
    public Hero computer;



    public boolean placeCard(int slotNumber, BoardSides side, Card card)
    {
        System.out.println("Don't mind me, I'm just placing " + card.getCardName() + " to slot number " + slotNumber + " on " + LocalizationHelper.getBoardSideName(side) + " side of the board.");
        return false;
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



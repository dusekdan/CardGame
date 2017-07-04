package cz.cuni.mff.game;

import cz.cuni.mff.models.BoardSides;

/**
 * Created by - on 4.7.2017.
 */
public class LocalizationHelper
{

    public static String getBoardSideName(BoardSides value)
    {
        return (value == BoardSides.LEFT) ? "left" : "right";
    }

}

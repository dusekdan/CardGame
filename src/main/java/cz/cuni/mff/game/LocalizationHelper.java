package cz.cuni.mff.game;

import cz.cuni.mff.models.BoardSides;
import cz.cuni.mff.models.MinionTypes;

/**
 * Created by - on 4.7.2017.
 */
public class LocalizationHelper
{

    public static String getBoardSideName(BoardSides value)
    {
        return (value == BoardSides.LEFT) ? "left" : "right";
    }

    public static String getMinionTypeName(MinionTypes value)
    {
        switch(value)
        {
            case REGULAR:
                return "Classic";
            case TAUNT:
                return "Taunt";
            case CHARGE:
                return "Charge";
        }
        return "Undefined";
    }

}

package cz.cuni.mff.game;

import cz.cuni.mff.models.BoardSides;
import cz.cuni.mff.models.MinionTypes;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */

/**
 * Helps with translation of Enum types to readable String name
 */
public class LocalizationHelper
{

    /**
     * Converts BoardSides value to readable String
     * @param value BoardSides Side to be printed
     * @return String Readable side identification
     */
    public static String getBoardSideName(BoardSides value)
    {
        return (value == BoardSides.LEFT) ? "left" : "right";
    }


    /**
     * Converts MinionTypes value to readable String
     * @param value MinionTypes Minion type to be printed
     * @return String Readable minion type name
     */
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
            default:
                return  "Undefined";
        }
    }

}

package helpers;
import java.io.*;
import java.util.*;
import java.awt.*;

/**
 * Created by David Riha on 5.7.2017.
 * Project: Simplified HearthStone java implementation
 *
 * Code for this class has been ripped of:
 * http://www.javaworld.com/article/2077578/learn-java/java-tip-76--an-alternative-to-the-deep-copy-technique.html
 *
 * Adds support for creation of deepCopies which is used
 * in deck/pack creation from prototypes.
 *
 * Efficiency and performance might be an issue.
 */
public class ObjectCloner
{
    // Prevents accidental ObjectCloner creation
    private ObjectCloner(){}

    // Returns deep copy of an object
    static public Object deepCopy(Object oldObj) throws Exception
    {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try
        {
            ByteArrayOutputStream bos =
                    new ByteArrayOutputStream(); // A
            oos = new ObjectOutputStream(bos); // B
            // serialize and pass the object
            oos.writeObject(oldObj);   // C
            oos.flush();               // D
            ByteArrayInputStream bin =
                    new ByteArrayInputStream(bos.toByteArray()); // E
            ois = new ObjectInputStream(bin);                  // F
            // return the new object
            return ois.readObject(); // G
        }
        catch(Exception e)
        {
            System.out.println("Exception in ObjectCloner = " + e);
            throw(e);
        }
        finally
        {
            oos.close();
            ois.close();
        }
    }

}

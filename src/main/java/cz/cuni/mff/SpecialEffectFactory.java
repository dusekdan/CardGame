package cz.cuni.mff;

import cz.cuni.mff.models.SpecialEffect;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by David Riha on 5.7.2017.
 * Project: Simplified HearthStone java implementation
 */
@Service
public class SpecialEffectFactory {
    /**
     * All possible special effects are stored within the effects ArrayList
     */
    private static ArrayList<SpecialEffect> effects = new ArrayList<SpecialEffect>();
    /**
     * Creates special effect based of parameters
     * TODO: To be implemented
     */
    public void createSpecialEffect()
    {
        System.out.println("Create special effect called!");
    }


    /**
     * Allows us to query specific effect using its name for identification
     * @param name String Special effect name
     * @return SpecialEffect Special Effect with corresponding name
     */
    public SpecialEffect getSpecialEffectByName(String name)
    {
        System.out.println("Yet to be implemented");
        return new SpecialEffect();
    }


    /**
     * Returns complete list of special effects generated using this factory
     * @return ArrayList<SpecialEffect> List of special effects
     */
    public ArrayList<SpecialEffect> getSpecialEffects()
    {
        return effects;
    }
}

package cz.cuni.mff;

import cz.cuni.mff.models.SpecialEffect;

import java.util.ArrayList;

/**
 * Created by - on 5.7.2017.
 */
public class SpecialEffectFactory {

    private static final SpecialEffectFactory instance = new SpecialEffectFactory();

    private static ArrayList<SpecialEffect> effects = new ArrayList<SpecialEffect>();


    public SpecialEffectFactory(){}


    public static SpecialEffectFactory getInstance() { return instance; }


    public void createSpecialEffect()
    {
        System.out.println("Create special effect called!");
    }


    public SpecialEffect getSpecialEffectByName(String name)
    {
        System.out.println("Yet to be implemented");
        return new SpecialEffect();
    }


    public ArrayList<SpecialEffect> getSpecialEffects()
    {
        return effects;
    }

}

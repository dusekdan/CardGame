package cz.cuni.mff.models;

/**
 * Created by David Riha on 5.7.2017.
 * Project: Simplified HearthStone java implementation
 */
public class SpecialEffect implements java.io.Serializable {

    /**
     * General Special Effect properties
     */
    private String description;
    private String name;
    private int healthEffect;
    private int manaEffect;
    private int manaCrystalEffect;

    // -- TargetType
    // -- EffectType (planning to calendar(?), battlecry / deathrattle / ...)
    // -- Positive | Negative effect (important for apply/reverse methods)
    // -- Method for applying effect
    // -- Method for reversing effect

    /**
     * Constructs Special Effect based on parameters
     */
    public SpecialEffect()
    {
        //System.out.println("Special effect constructor created.");
    }

}

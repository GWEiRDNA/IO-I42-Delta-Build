package pl.put.poznan.transformer.buildings;

/**
 * Default storage for all types of locatations.
 * Based on {@link LocationComposite}
 * @see LocationComposite
 * @see Location
 * @see LocINT
 */
public class CompoundLocation extends LocationComposite<Location> {
    /**
     * Default Constructor.
     * Default id is set to 0
     */
    public CompoundLocation(){
        super(0);
    }

    public CompoundLocation(int id){
        super(id);
    }
}

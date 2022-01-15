package pl.put.poznan.transformer.buildings;

import pl.put.poznan.transformer.visitors.Visitor;

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

    @Override
    public void accept(Visitor visitor) {visitor.visit(this);}
}

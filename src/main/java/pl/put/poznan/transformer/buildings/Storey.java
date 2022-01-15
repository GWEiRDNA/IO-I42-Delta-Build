package pl.put.poznan.transformer.buildings;

import pl.put.poznan.transformer.visitors.Visitor;

/**
 * Storey representation. Stored in Buildings. Stores Rooms{@link Room}
 * @see LocationComposite
 * @see Location
 * @see LocINT
 */
public class Storey extends LocationComposite<Room> {
    public Storey(int id) {
        super(id);
    }
    @Override
    public void accept(Visitor visitor) {visitor.visit(this);}
}


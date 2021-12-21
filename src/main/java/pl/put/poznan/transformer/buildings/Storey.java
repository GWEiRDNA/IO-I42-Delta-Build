package pl.put.poznan.transformer.buildings;

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
}

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

    /**
     * Gets the total light power of all of children
     * <code>Locations</code>  of the composite
     * @return double - total Ligth power
     */
    @Override
    public double getLight() {
        double total = 0;
        for (Room loc : locations) {
            total += loc.getLight();
        }
        return total/ getArea();
    }

    /**
     * Gets the total power usage to heat of all of children
     * <code>Locations</code> of the composite
     * @return double - total power usage of heating
     */
    @Override
    public double getHeating() {
        double total = 0;
        for (Room loc : locations) {
            total += loc.getHeating();
        }
        return total/ getCapacity();
    }
}


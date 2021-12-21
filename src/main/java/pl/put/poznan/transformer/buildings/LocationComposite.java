package pl.put.poznan.transformer.buildings;

import java.util.Vector;

/**
 * LocationComposite is the base abstract case for all of the Locations
 * in which other locations can be.
 * It makes default implementation for all of the Composites in the
 * Composite design pattern.
 * It also implements <code>LocINT</code> interface as in Composite design
 * pattern is mandatory.
 * @param <T> Class of the location object
 * @see Location
 * @see LocINT
 */
public abstract class LocationComposite<T extends Location> extends Location{
    protected Vector<T> locations = new Vector<>();

    public LocationComposite(int id){
        super(id);
    }

    /**
     * Adds new location to the composite
     * @param loc   New <code>Location</code>
     */
    public void add(T loc){
        locations.add(loc);
    }

    /**
     * Returns first Location object which is stored
     * in the composite of id matching the parameter id
     * @param id    id of <code>Location</code>
     * @return      First location with matching id
     * @throws Exception if id was not found inside
     *  (direct child) the Composite
     */
    public T at(int id) throws Exception {
        for (T location : locations) {
            if (location.getId() == id) {
                return location;
            }
        }
        throw new Exception("not found");
    }

    /**
     * Gets ids of Locations stored inside (direct child)
     * the Composite
     * @return Collection with IDs of Locations
     */
    public Vector<Integer> getChildrenIDs() {
        Vector<Integer> ids = new Vector<>();
        for (T location : locations) {
            ids.add(location.getId());
        }
        return ids;
    }

    /**
     * Deletes from Composite all the <code>Locations</code>
     * with matching id
     * @param id Id used to select desired <code>Location</code>
     */
    public void remove(int id) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).id == id) {
                locations.remove(i);
            }
        }
    }

    /**
     * Gets the total Area of all of children
     * <code>Locations</code>  of the composite
     * @return double - total area in square meters
     */
    @Override
    public double getArea() {
        int total = 0;
        for (T loc : locations) {
            total += loc.getArea();
        }
        return total;
    }

    /**
     * Gets the total cubature of all of children
     * <code>Locations</code>  of the composite
     * @return double - total cubature in cubic meters
     */
    @Override
    public double getCapacity() {
        int total = 0;
        for (T loc : locations) {
            total += loc.getCapacity();
        }
        return total;
    }

    /**
     * Gets the total light power of all of children
     * <code>Locations</code>  of the composite
     * @return double - total Ligth power
     */
    @Override
    public double getLight() {
        double total = 0;
        for (T loc : locations) {
            total += loc.getLight();
        }
        return total/ locations.size();
    }

    /**
     * Gets the total power usage to heat of all of children
     * <code>Locations</code> of the composite
     * @return double - total power usage of heating
     */
    @Override
    public double getHeating() {
        double total = 0;
        for (T loc : locations) {
            total += loc.getHeating();
        }
        return total/ locations.size();
    }
}
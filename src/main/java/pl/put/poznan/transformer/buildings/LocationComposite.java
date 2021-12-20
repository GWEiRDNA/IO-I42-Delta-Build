package pl.put.poznan.transformer.buildings;

import java.util.Vector;

public abstract class LocationComposite<T extends Location> extends Location{
    protected Vector<T> locations = new Vector<>();

    public LocationComposite(int id){
        super(id);
    }

    public void add(T loc){
        locations.add(loc);
    }

    public T at(int id) throws Exception {
        for (T location : locations) {
            if (location.getId() == id) {
                return location;
            }
        }
        throw new Exception("not found");
    }

    public Vector<Integer> getChildrenIDs() {
        Vector<Integer> ids = new Vector<>();
        for (T location : locations) {
            ids.add(location.getId());
        }
        return ids;
    }

    public void remove(int id) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).id == id) {
                locations.remove(i);
            }
        }
    }

    @Override
    public double getArea() {
        int total = 0;
        for (T loc : locations) {
            total += loc.getArea();
        }
        return total;
    }

    @Override
    public double getCapacity() {
        int total = 0;
        for (T loc : locations) {
            total += loc.getCapacity();
        }
        return total;
    }

    @Override
    public double getLight() {
        int total = 0;
        for (T loc : locations) {
            total += loc.getLight();
        }
        return total;
    }

    @Override
    public double getHeating() {
        float total = 0;
        for (T loc : locations) {
            total += loc.getHeating();
        }
        return total;
    }
}
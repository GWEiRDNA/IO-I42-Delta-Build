package pl.put.poznan.transformer.buildings;

import java.util.Vector;

public class CompoundLocation extends Location {
    // private int nextId = 0;
    private Vector<Location> locations = new Vector<>();

    public void add(Location loc) {
        locations.add(loc);
    }
    public void remove(int id) {
        for (int i = 0; i < locations.size(); i++) {
            locations.get(i).remove(id);

            // safe ?
            if (locations.get(i).id == id) {
                locations.remove(i);
            }
        }
    }
    public int getArea() {
        int total = 0;
        for (Location loc : locations) {
            total += loc.getArea();
        }
        return total;
    }
    public int getCapacity() {
        int total = 0;
        for (Location loc : locations) {
            total += loc.getCapacity();
        }
        return total;
    }
    public int getLight() {
        int total = 0;
        for (Location loc : locations) {
            total += loc.getCapacity();
        }
        return total;
    }
    public float getEating() {
        float total = 0;
        for (Location loc : locations) {
            total += loc.getEating();
        }
        return total;
    }
}

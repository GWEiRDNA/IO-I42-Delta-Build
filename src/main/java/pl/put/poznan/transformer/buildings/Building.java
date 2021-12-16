package pl.put.poznan.transformer.buildings;

import java.util.Vector;

public class Building extends CompositeLocation {
    private Vector<Storey> storeys = new Vector<Storey>();

    public void add(Location loc) {
        storeys.add((Storey)loc);
    }
    public void remove(int id) {
        for (int i = 0; i < storeys.size(); i++) {
            if (storeys.get(i).id == id) {
                storeys.removeElementAt(i);
            }
        }
    }
    public Location at(int id) {
        for (Location loc: storeys) {
            if (loc.id == id) {
                return loc;
            }
        }
        return null;
    }
    public Vector<Integer> getLeafIDs() {
        Vector<Integer> vec = new Vector<Integer>();
        for (Storey loc: storeys) {
            vec.addAll(loc.getLeafIDs());
        }
        return vec;
    }
    public Building(int id) {
        super.id = id;
    }
    public int getArea() {
        int total = 0;
        for (Storey storey : storeys) {
            total += storey.getArea();
        }
        return total;
    }
    public int getCapacity() {
        int total = 0;
        for (Storey storey : storeys) {
            total += storey.getCapacity();
        }
        return total;
    }
    public int getLight() {
        int total = 0;
        for (Storey storey : storeys) {
            total += storey.getLight();
        }
        return total;
    }
    public float getEating() {
        float total = 0;
        for (Storey storey : storeys) {
            total += storey.getEating();
        }
        return total;
    }
}
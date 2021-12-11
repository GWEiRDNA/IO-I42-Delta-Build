package pl.put.poznan.transformer.buildings;

import java.util.Vector;

public class Building extends Location {
    private Vector<Storey> storeys = new Vector<Storey>();

    public void add(Storey element) {
        storeys.add(element);
    }
    public void remove(int id) {
        for (int i = 0; i < storeys.size(); i++) {
            if (storeys.get(i).id == id) {
                storeys.removeElementAt(i);
            }
        }
    }
    Building(int id) {
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
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
    Building(int id, Storey storey) {
        super.id = id;
        this.add(storey);
    }
}
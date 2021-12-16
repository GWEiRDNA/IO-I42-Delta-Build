package pl.put.poznan.transformer.buildings;

import java.util.Vector;

abstract public class Location {
    int     id;
    String  name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    abstract public void remove(int id);

    abstract public int     getArea();
    abstract public int     getCapacity();
    abstract public int     getLight();
    abstract public float   getEating();

    abstract public Vector<Integer> getLeafIDs();
    public String toString()
    {
        return id + "(" + name + ") {" + "area:" + getArea() + " capacity:" + getCapacity() + " light:" + getLight() + " eating:" + getEating() + "}";
    }
}

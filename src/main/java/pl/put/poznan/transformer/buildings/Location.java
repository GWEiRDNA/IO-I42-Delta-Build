package pl.put.poznan.transformer.buildings;

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
}

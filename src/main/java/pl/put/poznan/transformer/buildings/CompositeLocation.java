package pl.put.poznan.transformer.buildings;

abstract public class CompositeLocation extends Location {
    abstract public void add(Location loc);
    abstract public void remove(int id);

    abstract public Location at(int id);
}

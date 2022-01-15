package pl.put.poznan.transformer.visitors;

import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

import java.util.Vector;

public class LightAvgVisitor implements Visitor{

    private double light = 0;
    private double area = 0;

    @Override
    public void reset() {
        light = 0;
        area = 0;
    }

    @Override
    public void visit(Room r) {
        light += r.getLight();
        area += r.getArea();
    }

    @Override
    public void visit(Storey s) {
        light += s.getLight();
        area += s.getArea();
    }

    @Override
    public void visit(Building b) {
        light += b.getLight();
        area += b.getArea();
    }

    @Override
    public Object getOutcome()
    {
        if(area == 0)
            return 0;
        return light/area;
    }
}
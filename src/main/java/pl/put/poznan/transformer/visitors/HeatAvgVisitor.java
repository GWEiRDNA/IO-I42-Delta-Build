package pl.put.poznan.transformer.visitors;

import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

public class HeatAvgVisitor implements Visitor{

    private double heating = 0;
    private double capacity = 0;

    @Override
    public void visit(Room r) {
        heating += r.getHeating();
        capacity += r.getCapacity();
    }

    @Override
    public void visit(Storey s) {
        heating += s.getHeating();
        capacity += s.getCapacity();
    }

    @Override
    public void visit(Building b) {
        heating += b.getHeating();
        capacity += b.getCapacity();
    }

    @Override
    public void visit(CompoundLocation cl) {
        heating += cl.getHeating();
        capacity += cl.getCapacity();
    }

    public double getOutcome()
    {
        if(capacity == 0)
            return 0;
        return heating/capacity;
    }
}
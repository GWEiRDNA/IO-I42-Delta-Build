package pl.put.poznan.transformer.visitors;

import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

import java.util.ArrayList;

public class HeatExceededVisitor implements Visitor{

    private double limit = 0;
    private double heating = 0;
    private double capacity = 0;

    private ArrayList<Room> out;

    public HeatExceededVisitor(double limit) {
        this.limit = limit;
        out = new ArrayList<Room>();
    }

    @Override
    public void visit(Room r) {
        if(r.getHeating()/r.getCapacity() > limit)
            out.add(r);
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

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public double getOutcome()
    {
        if(capacity == 0)
            return 0;
        return heating/capacity;
    }
}
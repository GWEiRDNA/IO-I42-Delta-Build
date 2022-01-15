package pl.put.poznan.transformer.visitors;

import org.springframework.cglib.beans.BulkBean;
import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.CompoundLocation;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

import java.util.ArrayList;

public class HeatExceededVisitor implements Visitor{

    public static final double DEFAULT_LIMIT = 10;
    private double limit = DEFAULT_LIMIT;
    private ArrayList<Integer> out;

    public HeatExceededVisitor(double limit) {
        this.limit = limit;
        out = new ArrayList<Integer>();
    }

    @Override
    public void reset() {
        out.clear();
    }

    @Override
    public void visit(Room r) {
        if(r.getHeating()/r.getCapacity() > limit)
            out.add(r.getId());
    }

    @Override
    public void visit(Storey s) {
        for (int id : s.getChildrenIDs()){
            try {visit(s.at(id));} catch (Exception e) {e.printStackTrace();}
        }
    }

    @Override
    public void visit(Building b) {
        for (int id : b.getChildrenIDs()){
            try {visit(b.at(id));} catch (Exception e) {e.printStackTrace();}
        }
    }

    @Override
    public Object getOutcome()
    {
        return out;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
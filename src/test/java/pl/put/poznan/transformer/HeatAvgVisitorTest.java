package pl.put.poznan.transformer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;
import pl.put.poznan.transformer.visitors.HeatAvgVisitor;

public class HeatAvgVisitorTest {

    HeatAvgVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new HeatAvgVisitor();
    }

    @Test
    void testVisitRoom() {
        Room mockRoom = mock(Room.class);

        when(mockRoom.getHeating()).thenReturn(37.5);
        when(mockRoom.getCapacity()).thenReturn(25.0);

        visitor.visit(mockRoom);
        visitor.getOutcome();
        assertEquals(1.5, visitor.getOutcome());
    }

    @Test
    void testVisitStorey() {
        Storey mockStorey= mock(Storey.class);

        when(mockStorey.getHeating()).thenReturn(37.5);
        when(mockStorey.getCapacity()).thenReturn(25.0);

        visitor.visit(mockStorey);
        visitor.getOutcome();
        assertEquals(1.5, visitor.getOutcome());
    }

    @Test
    void testVisitBuilding() {
        Building mockBuilding= mock(Building.class);

        when(mockBuilding.getHeating()).thenReturn(37.5);
        when(mockBuilding.getCapacity()).thenReturn(25.0);

        visitor.visit(mockBuilding);
        visitor.getOutcome();
        assertEquals(1.5, visitor.getOutcome());
    }
}

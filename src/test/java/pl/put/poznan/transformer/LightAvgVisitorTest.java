package pl.put.poznan.transformer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;
import pl.put.poznan.transformer.visitors.LightAvgVisitor;

public class LightAvgVisitorTest {

    LightAvgVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new LightAvgVisitor();
    }

    @Test
    void testVisitRoom() {
        Room mockRoom = mock(Room.class);

        when(mockRoom.getArea()).thenReturn(20.0);
        when(mockRoom.getLight()).thenReturn(25.0);

        visitor.visit(mockRoom);
        visitor.getOutcome();
        assertEquals(1.25, visitor.getOutcome());
    }

    @Test
    void testVisitStorey() {
        Storey mockStorey= mock(Storey.class);

        when(mockStorey.getArea()).thenReturn(20.0);
        when(mockStorey.getLight()).thenReturn(25.0);

        visitor.visit(mockStorey);
        visitor.getOutcome();
        assertEquals(1.25, visitor.getOutcome());
    }

    @Test
    void testVisitBuilding() {
        Building mockBuilding= mock(Building.class);

        when(mockBuilding.getArea()).thenReturn(20.0);
        when(mockBuilding.getLight()).thenReturn(25.0);

        visitor.visit(mockBuilding);
        visitor.getOutcome();
        assertEquals(1.25, visitor.getOutcome());
    }
}

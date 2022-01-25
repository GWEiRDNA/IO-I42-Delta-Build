package pl.put.poznan.transformer;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

import java.util.Vector;

public class LocationCompositeTest {
    Building testBuilding;
    Storey testStore;

    @BeforeEach
    void setUp() {
        testBuilding = new Building(1);

        Room testRoom;
        Room testRoom1;
        Room testRoom2;

        Storey testStore1;

        testRoom = new Room(1, 10, 10, 10, 10);
        testRoom1 = new Room(2, 10, 10, 10, 14);
        testRoom2 = new Room(3, 10, 10, 16, 16);

        testStore = new Storey(1);
        testStore1 = new Storey(2);

        testStore.add(testRoom);
        testStore.add(testRoom1);

        testStore1.add(testRoom2);

        testBuilding.add(testStore);
        testBuilding.add(testStore1);
    }

    @Test
    void buildingAtTest() {
        // incorrect
        assertThrows(Exception.class,
                () -> assertEquals(testStore, testBuilding.at(3)));
        // correct
        assertDoesNotThrow(() ->
                assertEquals(testStore, testBuilding.at(1)));
    }

    @Test
    void buildingGetChildrenIDsTest() {
        Vector<Integer> ids = new Vector<>();
        ids.add(1);
        ids.add(2);

        assertArrayEquals(ids.toArray(), testBuilding.getChildrenIDs().toArray());
    }

    @Test
    void buildingRemoveTest() {
        Vector<Integer> ids = new Vector<>();
        ids.add(1);

        testBuilding.remove(2);
        assertArrayEquals(ids.toArray(), testBuilding.getChildrenIDs().toArray());
    }

    @Test
    void buildingGetAreaTest() {
        assertEquals(30, testBuilding.getArea());
    }

    @Test
    void buildingGetCapacityTest() {
        assertEquals(30, testBuilding.getCapacity());
    }

    @Test
    void buildingGetLightTest() {
        assertEquals(36.0, testBuilding.getLight());
    }

    @Test
    void buildingGetHeatingTest() {
        assertEquals(40, testBuilding.getHeating());
    }
}
package pl.put.poznan.transformer;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.buildings.Building;
import pl.put.poznan.transformer.buildings.Room;
import pl.put.poznan.transformer.buildings.Storey;

public class StoreyTest {
    Storey      testStore;
    Room        testRoom;
    Room        testRoom1;
    Room        testRoom2;

    @BeforeEach
    void setUp() {
        testRoom    = new Room(1, 10, 11, 12, 20);
        testRoom1   = new Room(2, 10, 11, 12, 20);
        testRoom2   = new Room(3, 10, 11, 18, 26);

        testStore = new Storey(1);

        testStore.add(testRoom);
        testStore.add(testRoom1);
        testStore.add(testRoom2);
    }

    @Test
    void roomConstructorTest() {
        assertEquals(1,  testRoom.getId());
        assertEquals(10, testRoom.getArea());
        assertEquals(11, testRoom.getCapacity());
        assertEquals(12, testRoom.getLight());
        assertEquals(20, testRoom.getHeating());
    }

    @Test
    void storeyGetAreaTest() {
        assertEquals(30, testStore.getArea());
    }

    @Test
    void storeyGetCapacityTest() {
        assertEquals(33, testStore.getCapacity());
    }

    @Test
    void storeyGetLightTest() {
        assertEquals(1.4, testStore.getLight());
    }

    @Test
    void storeyGetHeatingTest() {
        assertEquals(2, testStore.getHeating());
    }
}

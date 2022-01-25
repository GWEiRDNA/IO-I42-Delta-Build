package pl.put.poznan.transformer;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.buildings.Room;

public class RoomTest {
    Room        testRoom;

    @BeforeEach
    void setUp() {
        testRoom    = new Room(1, 10, 11, 12, 20);
    }

    @Test
    void constructorValuesTest() {
        assertEquals(1,  testRoom.getId());
        assertEquals(10, testRoom.getArea());
        assertEquals(11, testRoom.getCapacity());
        assertEquals(12, testRoom.getLight());
        assertEquals(20, testRoom.getHeating());
    }

    @Test
    void constructorErrorTest() {
        assertThrows(Exception.class, ()-> new Room(-1, -1, -1, -1, -1));
    }

    @Test
    void setterTest() {
        assertThrows(Exception.class, ()-> testRoom.setArea(-100));
    }
}

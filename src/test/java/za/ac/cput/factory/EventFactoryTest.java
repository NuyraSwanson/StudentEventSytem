package za.ac.cput.factory;

/* Milani Sani : 230371574*/

import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class EventFactoryTest {

    @Test
    public void testCreateEvent() {
        Event event = EventFactory.createEvent(
                "E001",
                "Fresher's Party",
                "Annual music event on campus",
                LocalDate.of(2026, 4, 15),
                LocalTime.of(18, 0),
                200,
                true,
                "V001"
        );

        assertNotNull(event);
        assertEquals("E001", event.getEventId());
        assertEquals("Fresher's Party", event.getTitle());
        assertEquals(200, event.getCapacity());
        assertTrue(event.isActive());
    }

    @Test
    public void testEventHasVenueId() {
        Event event = EventFactory.createEvent(
                "E002",
                "Career Expo",
                "Annual career expo",
                LocalDate.of(2026, 5, 1),
                LocalTime.of(9, 0),
                500,
                true,
                "V001"
        );

        assertNotNull(event.getVenueId());
        assertEquals("V001", event.getVenueId());
    }

    @Test
    public void testEventIsActive() {
        Event event = EventFactory.createEvent(
                "E003",
                "Open Day",
                "Annual Open Day Event",
                LocalDate.of(2026, 6, 10),
                LocalTime.of(8, 0),
                300,
                true,
                "V002"
        );

        assertTrue(event.isActive());
    }

    @Test
    public void testEventIsInactive() {
        Event event = EventFactory.createEvent(
                "E004",
                "Cancelled Talk",
                "This event was cancelled",
                LocalDate.of(2026, 3, 1),
                LocalTime.of(10, 0),
                50,
                false,
                "V003"
        );

        assertFalse(event.isActive());
    }

}

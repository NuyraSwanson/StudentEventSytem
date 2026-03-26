package za.ac.cput.repository;
/* Milani Sani : 230371574
* 26 March 2026*/
import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.repository.event.IEventRepository;
import za.ac.cput.repository.event.impl.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EventRepositoryTest {
    private IEventRepository eventRepo;
        @BeforeEach
        public void setUp() {
            eventRepo = new EventRepository();
        }

        @Test
        public void testCreateEvent() {
            Event event = EventFactory.createEvent("E001", "Fresher's Party", "Annual Music Event", LocalDate.of(2026, 04, 15), LocalTime.of(20, 00), 500, true, "V001");

            eventRepo.create(event);
            assertNotNull(eventRepo.read("E001"));
        }

        @Test
        public void testReadEvent() {
            Event event = EventFactory.createEvent("E002", "Career Expo",
                    "Expo", LocalDate.of(2026, 05, 01),
                    LocalTime.of(9, 0), 500, true, "V001");

            eventRepo.create(event);
            assertEquals("Career Expo", eventRepo.read("E002").getTitle());
        }

    @Test
    public void testUpdateEvent() {
        Event event = EventFactory.createEvent("E003", "Old Title",
                "Desc", LocalDate.of(2026, 06, 01),
                LocalTime.of(10, 00), 100, true, "V001");

        eventRepo.create(event);

        Event updated = EventFactory.createEvent("E003", "Closed Day",
                "Desc", LocalDate.of(2026, 06, 01),
                LocalTime.of(10, 00), 100, true, "V001");

        eventRepo.update(updated);
        assertEquals("Open Day", eventRepo.read("E003").getTitle());
    }

    @Test
    public void testDeleteEvent() {
        Event event = EventFactory.createEvent("E004", "Talk",
                "Desc", LocalDate.of(2026, 7, 1),
                LocalTime.of(12, 0), 50, true, "V001");

        eventRepo.create(event);
        eventRepo.delete("E004");
        assertNull(eventRepo.read("E004"));
    }

    @Test
    public void testFindActiveEvents() {
        eventRepo.create(EventFactory.createEvent("E007", "Active Event",
                "Desc", LocalDate.of(2026, 4, 5),
                LocalTime.of(14, 0), 80, true, "V001"));
        eventRepo.create(EventFactory.createEvent("E008", "Inactive Event",
                "Desc", LocalDate.of(2026, 4, 6),
                LocalTime.of(15, 0), 80, false, "V001"));

        List<Event> activeEvents = eventRepo.findActiveEvents();
        assertEquals(1, activeEvents.size());
    }

    @Test
    public void testFindByVenueId() {
        eventRepo.create(EventFactory.createEvent("E009", "Event at V001",
                "Desc", LocalDate.of(2026, 4, 7),
                LocalTime.of(10, 0), 100, true, "V001"));
        eventRepo.create(EventFactory.createEvent("E010", "Event at V002",
                "Desc", LocalDate.of(2026, 4, 8),
                LocalTime.of(11, 0), 100, true, "V002"));

        List<Event> venueEvents = eventRepo.findByVenueId("V001");
        assertEquals(1, venueEvents.size());
    }
}

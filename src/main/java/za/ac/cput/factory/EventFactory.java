package za.ac.cput.factory;

/* Milani Sani : 230371574*/

import za.ac.cput.domain.Event;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventFactory {

    public static Event createEvent(String eventId,
                                    String title,
                                    String description,
                                    LocalDate eventDate,
                                    LocalTime eventTime,
                                    int capacity,
                                    boolean active,
                                    String venueId) {
        return new Event.Builder()
                .eventId(eventId)
                .title(title)
                .description(description)
                .eventDate(eventDate)
                .capacity(capacity)
                .active(active)
                .venueId(venueId)
                .build();
    }
}

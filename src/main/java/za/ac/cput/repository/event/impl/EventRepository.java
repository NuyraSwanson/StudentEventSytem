package za.ac.cput.repository.event.impl;

/* Milani Sani : 230371574*/

import za.ac.cput.domain.Event;
import za.ac.cput.repository.event.IEventRepository;
import  java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventRepository implements IEventRepository {

    private List<Event> events = new ArrayList<>();

    @Override
    public Event create(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event read(String id) {
        return events.stream()
                .filter(e -> e.getEventId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event update(Event event) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventId().equals(event.getEventId())) {
                events.set(i, event);
                return event;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return events.removeIf(e -> e.getEventId().equals(id));
    }

    @Override
    public List<Event> findActiveEvents() {
        return events.stream()
                .filter(Event::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findByVenueId(String venueId) {
        return events.stream()
                .filter(e -> e.getVenueId().equals(venueId))
                .collect(Collectors.toList());
    }
}

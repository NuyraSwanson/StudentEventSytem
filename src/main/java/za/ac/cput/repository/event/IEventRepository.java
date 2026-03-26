package za.ac.cput.repository.event;

/* Milani Sani : 230371574*/

import za.ac.cput.domain.Event;
import za.ac.cput.repository.IRepository;
import java.util.List;

public interface IEventRepository extends IRepository<Event, String> {
    List<Event> findActiveEvents();
    List<Event> findByVenueId(String venueId);
}

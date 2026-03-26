package za.ac.cput.repository.venue;
/*Author Angelia Van der Westhuizen
221420649
26 March 2026*/
import za.ac.cput.domain.Venue;
import java.util.Set;

public interface IVenueRepository {

    Venue create(Venue venue);

    Venue read(String venueId);

    Venue update(Venue venue);

    boolean delete(String venueId);

    Set<Venue> getAll();
}

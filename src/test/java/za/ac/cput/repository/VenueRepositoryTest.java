package za.ac.cput.repository;
/*Author Angelia Van der Westhuizen
221420649
26 March 2026*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Venue;
import za.ac.cput.factory.VenueFactory;
import za.ac.cput.repository.venue.impl.VenueRepository;

import static org.junit.jupiter.api.Assertions.*;

class VenueRepositoryTest {

    private static VenueRepository repository = VenueRepository.getRepository();
    private static Venue venue = VenueFactory.createVenue("HALL01", "Main Hall", 400);

    @Test
    void testCreate() {
        Venue created = repository.create(venue);
        assertNotNull(created);
    }

    @Test
    void testRead() {
        repository.create(venue);
        Venue read = repository.read("HALL01");
        assertNotNull(read);
    }

    @Test
    void testUpdate() {
        repository.create(venue);

        Venue updatedVenue = new Venue.Builder()
                .setVenueId("HALL01")
                .setVenueName("Sports Hall")
                .setCapacity(400)
                .build();

        Venue updated = repository.update(updatedVenue);
        assertNotNull(updated);
    }

    @Test
    void testGetAll() {
        assertNotNull(repository.getAll());
    }

    @Test
    void testDelete() {
        repository.create(venue);
        boolean deleted = repository.delete("HALL01");
        assertTrue(deleted);
    }
}
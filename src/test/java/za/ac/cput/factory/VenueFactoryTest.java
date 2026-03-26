package za.ac.cput.factory;

/*Author Angelia Van der Westhuizen
221420649
25 March 2026*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Venue;

import static org.junit.jupiter.api.Assertions.*;

class VenueFactoryTest {

    @Test
    void createVenue() {
        Venue venue = VenueFactory.createVenue("HALL01", "Main Hall", 400);

        assertNotNull(venue);
    }

    @Test
    void createVenueFail() {
        Venue venue = VenueFactory.createVenue("", "Main Hall", 400);

        assertNull(venue);
    }
}

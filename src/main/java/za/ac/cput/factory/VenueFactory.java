package za.ac.cput.factory;

/*Author Angelia Van der Westhuizen
221420649
 25 March 2026*/

import za.ac.cput.domain.Venue;

public class VenueFactory {

    public static Venue createVenue(String venueId, String venueName, int capacity) {

        if (venueId == null || venueId.isEmpty()) {
            return null;
        }

        if (venueName == null || venueName.isEmpty()) {
            return null;
        }

        if (capacity <= 0) {
            return null;
        }

        return new Venue.Builder()
                .setVenueId(venueId)
                .setVenueName(venueName)
                .setCapacity(capacity)
                .build();
    }
}
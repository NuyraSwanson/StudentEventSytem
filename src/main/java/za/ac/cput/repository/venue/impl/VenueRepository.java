package za.ac.cput.repository.venue.impl;
/*Author Angelia Van der Westhuizen
221420649
26 March 2026*/
import za.ac.cput.domain.Venue;
import za.ac.cput.repository.venue.IVenueRepository;

import java.util.HashSet;
import java.util.Set;

public class VenueRepository implements IVenueRepository {

    private static VenueRepository repository = null;
    private Set<Venue> venueSet;

    private VenueRepository() {
        venueSet = new HashSet<>();
    }

    public static VenueRepository getRepository() {
        if (repository == null) {
            repository = new VenueRepository();
        }
        return repository;
    }

    @Override
    public Venue create(Venue venue) {
        venueSet.add(venue);
        return venue;
    }

    @Override
    public Venue read(String venueId) {
        for (Venue v : venueSet) {
            if (v.getVenueId().equals(venueId)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public Venue update(Venue venue) {
        Venue oldVenue = read(venue.getVenueId());
        if (oldVenue != null) {
            venueSet.remove(oldVenue);
            venueSet.add(venue);
            return venue;
        }
        return null;
    }

    @Override
    public boolean delete(String venueId) {
        Venue venue = read(venueId);
        if (venue != null) {
            venueSet.remove(venue);
            return true;
        }
        return false;
    }

    @Override
    public Set<Venue> getAll() {
        return venueSet;
    }
}
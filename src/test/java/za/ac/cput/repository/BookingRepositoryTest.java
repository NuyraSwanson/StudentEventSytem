package za.ac.cput.repository;

/*Author Jada Rinquest
222871296
Created 25 March 2026*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.booking.impl.BookingRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    BookingRepository repository = BookingRepository.getRepository();

    @Test
    void testCRUD() {

        Booking booking = BookingFactory.createBooking("S1", "E1", 2);
        assertNotNull(booking);

        // Create
        Booking created = repository.create(booking);
        assertEquals(booking.getBookingId(), created.getBookingId());

        // Read
        Booking read = repository.read(booking.getBookingId());
        assertNotNull(read);

        // Update
        Booking updated = new Booking.Builder()
                .setBookingId(booking.getBookingId())
                .setStudentId("S2")
                .setEventId("E1")
                .setNumberOfTickets(3)
                .build();

        repository.update(updated);
        assertEquals(3, repository.read(booking.getBookingId()).getNumberOfTickets());

        // Delete
        repository.delete(booking.getBookingId());
        assertNull(repository.read(booking.getBookingId()));
    }
}
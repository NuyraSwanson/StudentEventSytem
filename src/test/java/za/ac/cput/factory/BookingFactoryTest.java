package za.ac.cput.factory;

/*Author Jada Rinquest
222871296
 25 March 2026*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void testCreateBooking() {
        Booking booking = BookingFactory.createBooking("S1", "E1", 2);
        assertNotNull(booking);
    }

    @Test
    void testCreateBookingFail() {
        Booking booking = BookingFactory.createBooking(null, "E1", 2);
        assertNull(booking);
    }
}
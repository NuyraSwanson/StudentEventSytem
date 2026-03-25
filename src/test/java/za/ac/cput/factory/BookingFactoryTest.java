package za.ac.cput.factory;

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
package za.ac.cput.factory;

import za.ac.cput.domain.Booking;

import java.util.UUID;

public class BookingFactory {

    public static Booking createBooking(String studentId, String eventId, int numberOfTickets) {

        if (studentId == null || eventId == null || numberOfTickets <= 0) {
            return null;
        }

        String bookingId = UUID.randomUUID().toString();

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setEventId(eventId)
                .setNumberOfTickets(numberOfTickets)
                .build();
    }
}

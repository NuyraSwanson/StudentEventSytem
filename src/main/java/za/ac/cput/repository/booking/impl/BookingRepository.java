package za.ac.cput.repository.booking.impl;

import za.ac.cput.domain.Booking;
import za.ac.cput.repository.booking.IBookingRepository;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository implements IBookingRepository {

    private static BookingRepository repository = null;
    private Map<String, Booking> bookingTable;

    private BookingRepository() {
        bookingTable = new HashMap<>();
    }

    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        bookingTable.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Booking read(String bookingId) {
        return bookingTable.get(bookingId);
    }

    @Override
    public Booking update(Booking booking) {
        bookingTable.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public boolean delete(String bookingId) {
        bookingTable.remove(bookingId);
        return true;
    }
}

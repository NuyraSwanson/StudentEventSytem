package za.ac.cput;

import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.booking.impl.BookingRepository;
import za.ac.cput.repository.student.impl.StudentRepository;
import za.ac.cput.repository.ticket.impl.TicketRepository;
import za.ac.cput.repository.venue.impl.VenueRepository;
import za.ac.cput.repository.event.impl.EventRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        // ===== CREATE OBJECTS USING FACTORIES =====
        Student student = StudentFactory.createStudent("S1", "Jada", "jada@mail.com");
        Venue venue = VenueFactory.createVenue("V1", "Main Hall", 500);

        Event event = EventFactory.createEvent(
                "E1",
                "Tech Talk",
                "AI Discussion",
                LocalDate.of(2026, 4, 10),
                LocalTime.of(10, 0),
                100,
                true,
                "V1"
        );

        Booking booking = BookingFactory.createBooking("S1", "E1", 2);

        Ticket ticket = TicketFactory.createTicket(
                booking.getBookingId(),
                "VIP",
                150.0,
                "A1"
        );

        // ===== REPOSITORIES =====
        StudentRepository studentRepo = StudentRepository.getRepository();
        VenueRepository venueRepo = VenueRepository.getRepository();
        EventRepository eventRepo = new EventRepository();
        BookingRepository bookingRepo = BookingRepository.getRepository();
        TicketRepository ticketRepo = TicketRepository.getRepository();

        // ===== SAVE DATA =====
        studentRepo.create(student);
        venueRepo.create(venue);
        eventRepo.create(event);
        bookingRepo.create(booking);
        ticketRepo.create(ticket);

        // ===== READ + DISPLAY =====
        System.out.println("Student: " + studentRepo.read("S1").getName());
        System.out.println("Venue: " + venueRepo.read("V1").getVenueName());
        System.out.println("Event: " + eventRepo.read("E1").getTitle());
        System.out.println("Booking Tickets: " + bookingRepo.read(booking.getBookingId()).getNumberOfTickets());
        System.out.println("Ticket Type: " + ticket.getTicketType());

        // ===== EXTRA (optional - shows your skills) =====
        System.out.println("\nActive Events:");
        eventRepo.findActiveEvents().forEach(e ->
                System.out.println(e.getTitle())
        );
    }
}
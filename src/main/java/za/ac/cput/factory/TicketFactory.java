package za.ac.cput.factory;

import za.ac.cput.domain.Ticket;
import java.util.UUID;

public class TicketFactory {

    public static Ticket createTicket(String bookingId,
                                      String ticketType,
                                      double price,
                                      String seatNumber) {
        if (bookingId == null || bookingId.isEmpty()
              || ticketType == null || ticketType.isEmpty()
              || price <= 0
              || seatNumber == null || seatNumber.isEmpty()) {
            return null;
        }

        String ticketId = UUID.randomUUID().toString();

        return new Ticket.Builder()
                .setTicketId(ticketId)
                .setBookingId(bookingId)
                .setTicketType(ticketType)
                .setPrice(price)
                .setSeatNumber(seatNumber)
                .build();
    }
}

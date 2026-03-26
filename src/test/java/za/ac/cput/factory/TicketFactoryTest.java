/* Nuyra Swanson: 221290524 */

package za.ac.cput.factory;

import za.ac.cput.domain.Ticket;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketFactoryTest {

    @Test
    public void testCreateTicket() {

        Ticket ticket = TicketFactory.createTicket(
                "B001",
                "VIP",
                150.0,
                "A12"
        );

        assertNotNull(ticket);
        assertNotNull(ticket.getTicketId());
        assertEquals("B001", ticket.getBookingId());
        assertEquals("VIP", ticket.getTicketType());
        assertEquals(150.0, ticket.getPrice());
        assertEquals("A12", ticket.getSeatNumber());
    }

    @Test
    public void testCreateTicketFail() {

        Ticket ticket = TicketFactory.createTicket(
                "",   // invalid bookingId
                "VIP",
                150.0,
                "A12"
        );

        assertNull(ticket);
    }
}

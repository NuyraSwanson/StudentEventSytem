/* Nuyra Swanson: 221290524 */

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Ticket;
import za.ac.cput.factory.TicketFactory;
import za.ac.cput.repository.ticket.impl.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {

    TicketRepository repository = TicketRepository.getRepository();

    @Test
    void testCRUD() {
        Ticket ticket = TicketFactory.createTicket("B001", "VIP", 150.0, "A12");
        assertNotNull(ticket);

        Ticket created = repository.create(ticket);
        assertEquals(ticket.getTicketId(), created.getTicketId());

        Ticket read = repository.read(ticket.getTicketId());
        assertNotNull(read);

        Ticket updated= new Ticket.Builder()
                .setBookingId(ticket.getTicketId())
                .setBookingId("B002")
                .setTicketType("General")
                .setPrice(100.0)
                .setSeatNumber("B10")
                .build();

        repository.update(updated);
        assertEquals("General", repository.read(ticket.getTicketId()).getTicketType());

        repository.delete(ticket.getTicketId());
        assertNull(repository.read(ticket.getTicketId()));
    }

}

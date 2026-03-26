/* Nuyra Swanson: 221290524 */

package za.ac.cput.repository.ticket;

import za.ac.cput.domain.Ticket;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface ITicketRepository extends IRepository<Ticket, String> {
    List<Ticket> findByBookingId(String bookingId);
    List<Ticket> findByTicketType(String ticketType);
}

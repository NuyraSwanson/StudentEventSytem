/* Nuyra Swanson: 221290524 */

package za.ac.cput.repository.ticket.impl;

import za.ac.cput.domain.Ticket;
import za.ac.cput.repository.ticket.ITicketRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketRepository implements ITicketRepository {
    private static TicketRepository repository = null;
    private Set<Ticket> ticketDB;

    private TicketRepository() {
        ticketDB = new HashSet<>();
    }

    public static TicketRepository getRepository() {
        if (repository == null) {
            repository = new TicketRepository();
        }
        return repository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        ticketDB.add(ticket);
        return ticket;
    }

    @Override
    public Ticket read(String ticketId) {
        return ticketDB.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket existing = read(ticket.getTicketId());
        if (existing != null) {
            ticketDB.remove(existing);
            ticketDB.add(ticket);
            return ticket;
        }
        return null;
    }

    @Override
    public boolean delete(String ticketId) {
        Ticket ticket = read(ticketId);
        if (ticket != null) {
            ticketDB.remove(ticket);
            return true;
        }
        return false;
    }

    public List<Ticket> getAll() {
        return ticketDB.stream().toList();
    }

    @Override
    public List<Ticket> findByBookingId(String bookingId) {
        return ticketDB.stream()
                .filter(ticket -> ticket.getBookingId().equals(bookingId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findByTicketType(String ticketType) {
        return ticketDB.stream()
                .filter(ticket -> ticket.getTicketType().equalsIgnoreCase(ticketType))
                .collect(Collectors.toList());
    }
}

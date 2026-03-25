package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private String eventId;
    private String title;
    private String description;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int capacity;
    private boolean active;
    private String venueId;

    private Event(Builder builder) {
        this.eventId = builder.eventId;
        this.title = builder.title;
        this.description = builder.description;
        this.eventDate = builder.eventDate;
        this.eventTime = builder.eventTime;
        this.capacity = builder.capacity;
        this.active = builder.active;
        this.venueId = builder.venueId;
    }

    public String getEventId() {return eventId;}
    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public LocalDate getEventDate() {return eventDate;}
    public LocalTime getEventTime() {return eventTime;}
    public int getCapacity() {return capacity;}
    public boolean isActive() {return active;}
    public String getVenueId() {return venueId;}

    public static class Builder{
        private String eventId;
        private String title;
        private String description;
        private LocalDate eventDate;
        private LocalTime eventTime;
        private int capacity;
        private boolean active;
        private String venueId;

        public Builder eventId(String eventId){this.eventId = eventId; return this; }
        public Builder title(String title){this.title = title; return this; }
        public Builder description(String description){this.description = description; return this; }
        public Builder eventDate(LocalDate eventDate){this.eventDate = eventDate; return this; }
        public Builder eventTime(LocalTime eventTime){this.eventTime = eventTime; return this; }
        public Builder capacity(int capacity){this.capacity = capacity; return this; }
        public Builder active(boolean active){this.active = active; return this; }
        public Builder venueId(String venueId){this.venueId = venueId; return this; }
        public Event build() { return new Event(this); }
    }
}

/* Milani Sani EventDomain*/
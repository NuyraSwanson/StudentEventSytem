package za.ac.cput.domain;

public class Booking {

    private String bookingId;
    private String studentId;
    private String eventId;
    private int numberOfTickets;

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.studentId = builder.studentId;
        this.eventId = builder.eventId;
        this.numberOfTickets = builder.numberOfTickets;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEventId() {
        return eventId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static class Builder {
        private String bookingId;
        private String studentId;
        private String eventId;
        private int numberOfTickets;

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setNumberOfTickets(int numberOfTickets) {
            this.numberOfTickets = numberOfTickets;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}


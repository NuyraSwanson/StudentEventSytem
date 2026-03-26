package za.ac.cput.domain;

public class Venue {

    private String venueId;
    private String venueName;
    private int capacity;

    private Venue(Builder builder) {
        this.venueId = builder.venueId;
        this.venueName = builder.venueName;
        this.capacity = builder.capacity;
    }

    public String getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class Builder {
        private String venueId;
        private String venueName;
        private int capacity;

        public Builder setVenueId(String venueId) {
            this.venueId = venueId;
            return this;
        }

        public Builder setVenueName(String venueName) {
            this.venueName = venueName;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Venue build() {
            return new Venue(this);
        }
    }
}

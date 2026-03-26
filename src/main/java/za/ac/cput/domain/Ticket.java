/* Nuyra Swanson: 221290524 */

package za.ac.cput.domain;

public class Ticket {
  private String ticketId;
  private String bookingId;
  private String ticketType;
  private double price;
  private String seatNumber;

  private Ticket(Builder builder) {
      this.ticketId = builder.ticketId;
      this.bookingId = builder.bookingId;
      this.ticketType = builder.ticketType;
      this.price = builder.price;
      this.seatNumber = builder.seatNumber;
  }

  public String getTicketId() {
      return ticketId;
  }

  public String getBookingId() {
      return bookingId;
  }

  public String getTicketType() {
      return ticketType;
  }

  public double getPrice() {
      return price;
  }

  public String getSeatNumber() {
      return seatNumber;
  }

  public static  class Builder {
      private String ticketId;
      private String bookingId;
      private String ticketType;
      private double price;
      private String seatNumber;

      public Builder setTicketId(String ticketId) {
          this.ticketId = ticketId;
          return this;
      }

      public Builder setBookingId(String bookingId) {
          this.bookingId = bookingId;
          return this;
      }

      public Builder setTicketType(String ticketType) {
          this.ticketType = ticketType;
          return this;
      }

      public Builder setPrice(double price) {
          this.price = price;
          return this;
      }

      public Builder setSeatNumber(String seatNumber) {
          this.seatNumber = seatNumber;
          return this;
      }

      public Ticket build() {
          return new Ticket(this);
      }
  }

}

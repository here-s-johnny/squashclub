package pl.s18280.squashclub.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.s18280.squashclub.command.domain.booking.Booking;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_generator")
    @SequenceGenerator(name="booking_generator", sequenceName = "booking_seq", initialValue = 500)
    private Long id;
    private String date;
    private Integer hour;
    private Integer court;
    private String username;

    public BookingEntity(Booking booking) {
        this.date = booking.getDate().getValue();
        this.hour = booking.getHour().getValue();
        this.court = booking.getCourt().getNumber();
        this.username = booking.getUsername().getValue();
    }

    public pl.s18280.squashclub.command.domain.booking.Booking toCommandBooking() {
        return new pl.s18280.squashclub.command.domain.booking.Booking(this.getDate(), this.getHour(), this.getUsername(), this.getCourt());
    }

    public pl.s18280.squashclub.query.domain.bookings.Booking toQueryBooking() {
        return new pl.s18280.squashclub.query.domain.bookings.Booking(this.getDate(), this.getHour(), this.getCourt());
    }
}

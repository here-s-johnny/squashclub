package pl.s18280.squashclub.command.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.s18280.squashclub.query.domain.bookings.Booking;

import java.util.List;

@AllArgsConstructor
@Data
public class Bookings {
    private List<Booking> bookings;
}

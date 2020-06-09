package pl.s18280.squashclub.query.domain.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.command.domain.booking.Bookings;
import pl.s18280.squashclub.common.aggregates.Hours;
import pl.s18280.squashclub.common.valueobject.Hour;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsRetriever {

    public static final Integer COURTS_AMOUNT = 2;

    private final BookingsDatabaseAdapter bookingsDatabaseAdapter;

    public Hours retrieveUnavailableBookingHours(String date) {
        List<Hour> bookingHours = bookingsDatabaseAdapter.findAllByDate(date).stream()
                .map(Booking::getHour)
                .collect(Collectors.toList());

        return new Hours(
                bookingHours.stream()
                        .filter(hour -> Collections.frequency(bookingHours, hour) >= COURTS_AMOUNT)
                        .collect(Collectors.toSet())
        );
    }

    public Bookings retrieveBookingsForUser(String username) {
        return new Bookings(bookingsDatabaseAdapter.findAllByUsername(username));
    }
}

package pl.s18280.squashclub.command.domain.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.command.api.CreateBookingRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingCreator {

    private final BookingDatabaseAdapter bookingDatabaseAdapter;

    public void create(CreateBookingRequest createBookingRequest) {
        List<Booking> bookings = bookingDatabaseAdapter.findAllByDateAndHour(createBookingRequest.getDate(), createBookingRequest.getHour());

        Booking booking = new Booking(createBookingRequest.getDate(), createBookingRequest.getHour(), createBookingRequest.getUsername(), bookings);
        bookingDatabaseAdapter.save(booking);
    }
}

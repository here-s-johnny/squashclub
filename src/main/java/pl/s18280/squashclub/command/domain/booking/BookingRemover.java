package pl.s18280.squashclub.command.domain.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.command.api.DeleteBookingRequest;

@Service
@RequiredArgsConstructor
public class BookingRemover {

    private final BookingDatabaseAdapter bookingDatabaseAdapter;

    public void remove(DeleteBookingRequest deleteBookingRequest) {
        Booking booking = bookingDatabaseAdapter.findByDateAndHourAndCourt(
                deleteBookingRequest.getDate(),
                deleteBookingRequest.getHour(),
                deleteBookingRequest.getCourt()
        );

        if (booking == null) {
            throw new RuntimeException("No booking to remove!");
        }

        bookingDatabaseAdapter.delete(booking);
    }
}

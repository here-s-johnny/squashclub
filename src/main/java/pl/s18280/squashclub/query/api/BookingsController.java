package pl.s18280.squashclub.query.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.s18280.squashclub.common.aggregates.Hours;
import pl.s18280.squashclub.common.valueobject.Hour;
import pl.s18280.squashclub.query.domain.bookings.BookingsRetriever;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class BookingsController {

    private final BookingsRetriever bookingsRetriever;

    @GetMapping
    public UnavailableBookingsResponse listUnavailable(@RequestParam(name = "date") String date) {
        Hours bookingHours = bookingsRetriever.retrieveUnavailableBookingHours(date);
        return new UnavailableBookingsResponse(date, bookingHours.getHours().stream().map(Hour::getValue).collect(Collectors.toSet()));
    }

    @GetMapping("/users/{username}")
    public BookingsResponse listBookings(@PathVariable(name = "username") String username) {
        List<BookingResponse> bookings = bookingsRetriever.retrieveBookingsForUser(username).getBookings().stream()
                .map(booking -> new BookingResponse(booking.getDate().getValue(), booking.getHour().getValue(), booking.getCourt().getNumber()))
                .collect(Collectors.toList());

        return new BookingsResponse(bookings);
    }
}

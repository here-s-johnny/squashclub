package pl.s18280.squashclub.command.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.s18280.squashclub.command.domain.booking.BookingCreator;
import pl.s18280.squashclub.command.domain.booking.BookingRemover;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class BookingController {

    private final BookingCreator bookingCreator;
    private final BookingRemover bookingRemover;

    @PostMapping
    public void create(@RequestBody CreateBookingRequest createBookingRequest) {
        bookingCreator.create(createBookingRequest);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteBookingRequest deleteBookingRequest) {
        bookingRemover.remove(deleteBookingRequest);
    }
}
package pl.s18280.squashclub.query.domain.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.common.entity.BookingEntity;
import pl.s18280.squashclub.common.infrastructure.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookingsDatabaseAdapter {

    private final BookingRepository bookingRepository;

    List<Booking> findAllByDate(String date) {
        return bookingRepository.findAllByDate(date).stream()
                .map(BookingEntity::toQueryBooking)
                .collect(Collectors.toList());
    }

    List<Booking> findAllByUsername(String username) {
        return bookingRepository.findAllByUsername(username).stream()
                .map(BookingEntity::toQueryBooking)
                .collect(Collectors.toList());
    }
}

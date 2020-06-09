package pl.s18280.squashclub.command.domain.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.s18280.squashclub.common.entity.BookingEntity;
import pl.s18280.squashclub.common.infrastructure.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookingDatabaseAdapter {

    private final BookingRepository bookingRepository;

    List<Booking> findAllByDateAndHour(String date, Integer hour) {
        return bookingRepository.findAllByDateAndHour(date, hour).stream()
                .map(BookingEntity::toCommandBooking)
                .collect(Collectors.toList());
    }

    Booking findByDateAndHourAndCourt(String date, Integer hour, Integer court) {
        BookingEntity bookingEntity = bookingRepository.findByDateAndHourAndCourt(date, hour, court);
        if (bookingEntity == null) {
            return null;
        }
        return bookingEntity.toCommandBooking();
    }

    void delete(Booking booking) {
        BookingEntity bookingEntity = bookingRepository.findByDateAndHourAndCourt(
                booking.getDate().getValue(),
                booking.getHour().getValue(),
                booking.getCourt().getNumber()
        );
        bookingRepository.delete(bookingEntity);
    }

    void save(Booking booking) {
        BookingEntity bookingEntity = new BookingEntity(booking);
        bookingRepository.save(bookingEntity);
    }
}

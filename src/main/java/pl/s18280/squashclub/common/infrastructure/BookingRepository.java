package pl.s18280.squashclub.common.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.s18280.squashclub.common.entity.BookingEntity;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findAllByDateAndHour(String date, Integer hour);
    BookingEntity findByDateAndHourAndCourt(String date, Integer hour, Integer court);
    List<BookingEntity> findAllByDate(String date);
    List<BookingEntity> findAllByUsername(String username);
}

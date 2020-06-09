package pl.s18280.squashclub.query.domain.bookings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.s18280.squashclub.command.domain.booking.Bookings;
import pl.s18280.squashclub.common.aggregates.Hours;
import pl.s18280.squashclub.common.valueobject.Hour;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingsRetrieverTest {

    private static final String DATE = "2020-17-05";
    private static final Integer HOUR = 11;
    private static final String USERNAME = "username";

    @Mock
    private BookingsDatabaseAdapter bookingsDatabaseAdapter;
    @Mock
    private Booking bookingAlpha;
    @Mock
    private Booking bookingBravo;
    @Mock
    private Booking bookingCharlie;

    private BookingsRetriever bookingsRetriever;

    @BeforeEach
    void setup() {
        bookingsRetriever = new BookingsRetriever(bookingsDatabaseAdapter);
    }

    @Test
    void shouldRetrieveUnavailableBookingHours() {
        Hour hour = new Hour(HOUR);
        when(bookingAlpha.getHour()).thenReturn(hour);
        when(bookingBravo.getHour()).thenReturn(hour);
        when(bookingCharlie.getHour()).thenReturn(hour);
        when(bookingsDatabaseAdapter.findAllByDate(DATE)).thenReturn(Arrays.asList(bookingAlpha, bookingBravo, bookingCharlie));

        Hours hours = bookingsRetriever.retrieveUnavailableBookingHours(DATE);

        assertThat(hours.getHours()).hasSize(1);
        assertThat(hours.getHours()).containsExactly(hour);
    }

    @Test
    void shouldNotRetrieveBookingHoursIfThereAreStillFreeCourtsLeft() {
        Hour hour = new Hour(HOUR);
        when(bookingAlpha.getHour()).thenReturn(hour);
        when(bookingsDatabaseAdapter.findAllByDate(DATE)).thenReturn(Collections.singletonList(bookingAlpha));

        Hours hours = bookingsRetriever.retrieveUnavailableBookingHours(DATE);

        assertThat(hours.getHours()).isEmpty();
    }

    @Test
    void shouldNotReturnBookingHoursIfNoBookingsFoundForGivenDate() {
        when(bookingsDatabaseAdapter.findAllByDate(DATE)).thenReturn(Collections.emptyList());

        Hours hours = bookingsRetriever.retrieveUnavailableBookingHours(DATE);

        assertThat(hours.getHours()).isEmpty();
    }

    @Test
    void shouldReturnAllBookingsForGivenUsername() {
        when(bookingsDatabaseAdapter.findAllByUsername(USERNAME)).thenReturn(Collections.singletonList(bookingAlpha));

        Bookings bookings = bookingsRetriever.retrieveBookingsForUser(USERNAME);

        assertThat(bookings.getBookings()).isNotEmpty();
        assertThat(bookings.getBookings()).hasSize(1);
        assertThat(bookings.getBookings()).containsExactly(bookingAlpha);
    }

    @Test
    void shouldNotReturnBookingsIfNoBookingsFoundForGivenUsername() {
        when(bookingsDatabaseAdapter.findAllByUsername(USERNAME)).thenReturn(Collections.emptyList());

        Bookings bookings = bookingsRetriever.retrieveBookingsForUser(USERNAME);

        assertThat(bookings.getBookings()).isEmpty();
    }
}

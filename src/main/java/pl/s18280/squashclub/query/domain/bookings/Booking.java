package pl.s18280.squashclub.query.domain.bookings;


import lombok.AllArgsConstructor;
import lombok.Data;
import pl.s18280.squashclub.common.valueobject.Court;
import pl.s18280.squashclub.common.valueobject.Date;
import pl.s18280.squashclub.common.valueobject.Hour;

@AllArgsConstructor
@Data
public class Booking {
    private Date date;
    private Hour hour;
    private Court court;

    public Booking(String date, Integer hour, Integer court) {
        this.date = new Date(date);
        this.hour = new Hour(hour);
        this.court = new Court(court);
    }
}

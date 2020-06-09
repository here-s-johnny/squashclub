package pl.s18280.squashclub.command.domain.booking;

import lombok.Data;
import pl.s18280.squashclub.command.domain.exception.ValidationException;
import pl.s18280.squashclub.common.valueobject.Court;
import pl.s18280.squashclub.common.valueobject.Date;
import pl.s18280.squashclub.common.valueobject.Hour;
import pl.s18280.squashclub.common.valueobject.Username;

import java.util.List;

@Data
public class Booking {

    public static Integer COURTS_AMOUNT = 2;

    private Date date;
    private Hour hour;
    private Court court;
    private Username username;

    public Booking(String date, Integer hour, String username, List<Booking> bookingsDone) {
        if (bookingsDone.size() >= COURTS_AMOUNT) {
            throw new ValidationException("Creation error. No courts left");
        }
        this.date = new Date(date);
        this.hour = new Hour(hour);
        this.court = new Court(bookingsDone.size() + 1);
        this.username = new Username(username);
    }

    public Booking(String date, Integer hour, String username, Integer court) {
        this.date = new Date(date);
        this.hour = new Hour(hour);
        this.court = new Court(court);
        this.username = new Username(username);
    }
}

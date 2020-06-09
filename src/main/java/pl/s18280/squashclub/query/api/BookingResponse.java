package pl.s18280.squashclub.query.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookingResponse {
    private String date;
    private Integer hour;
    private Integer court;
}

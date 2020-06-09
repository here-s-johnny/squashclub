package pl.s18280.squashclub.query.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnavailableBookingsResponse {
    private String date;
    private Set<Integer> bookingHours;
}

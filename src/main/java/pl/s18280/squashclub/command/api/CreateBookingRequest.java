package pl.s18280.squashclub.command.api;

import lombok.Data;

@Data
public class CreateBookingRequest {
    private String date;
    private Integer hour;
    private String username;
}

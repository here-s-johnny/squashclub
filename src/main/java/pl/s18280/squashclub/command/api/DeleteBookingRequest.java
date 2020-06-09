package pl.s18280.squashclub.command.api;

import lombok.Data;

@Data
public class DeleteBookingRequest {
    private String date;
    private Integer hour;
    private Integer court;
}

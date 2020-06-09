package pl.s18280.squashclub.command.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegistrationResponse {
    private Boolean success;
    private String message;
}

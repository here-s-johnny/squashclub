package pl.s18280.squashclub.command.domain.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum RegistrationStatus {
    USERNAME_TAKEN("username taken", false),
    EMAIL_ALREADY_REGISTERED("email already registered", false),
    SUCCESS("", true);

    private String message;
    private Boolean success;
}

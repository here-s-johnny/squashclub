package pl.s18280.squashclub.query.domain.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum LoginStatus {
    USER_NOT_FOUND("user not found", false),
    PASSWORD_INCORRECT("password incorrect", false),
    SUCCESS("", true);

    private String message;
    private Boolean success;
}

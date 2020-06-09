package pl.s18280.squashclub.command.domain.registration;

import lombok.Data;
import pl.s18280.squashclub.command.domain.exception.ValidationException;
import pl.s18280.squashclub.common.valueobject.Email;
import pl.s18280.squashclub.common.valueobject.Password;
import pl.s18280.squashclub.common.valueobject.Username;

@Data
public class User {

    private Username username;
    private Email email;
    private Password password;

    public User(String username, String email, String password) {
        this.username = new Username(username);
        this.email = new Email(email);
        validatePassword(password);
        this.password = new Password(password);
    }

    private void validatePassword(String password) {
        if (password.length() < 5) {
            throw new ValidationException("Password too short!");
        }
    }
}

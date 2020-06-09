package pl.s18280.squashclub.query.domain.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.s18280.squashclub.common.valueobject.Password;
import pl.s18280.squashclub.common.valueobject.Username;

@AllArgsConstructor
@Data
public class User {
    private Username username;
    private Password password;

    public User(String username, String password) {
        this.username = new Username(username);
        this.password = new Password(password);
    }
}

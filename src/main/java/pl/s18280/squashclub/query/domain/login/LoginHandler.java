package pl.s18280.squashclub.query.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHandler {

    private final UsersDatabaseAdapter usersDatabaseAdapter;

    public LoginStatus handleLogin(LoginForm loginForm) {
        User user = usersDatabaseAdapter.getByUsername(loginForm.getUsername());
        if (user == null) {
            return LoginStatus.USER_NOT_FOUND;
        }

        return user.getPassword().getValue().equals(loginForm.getPassword()) ?
                LoginStatus.SUCCESS :
                LoginStatus.PASSWORD_INCORRECT;
    }
}

package pl.s18280.squashclub.query.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.s18280.squashclub.query.domain.login.LoginForm;
import pl.s18280.squashclub.query.domain.login.LoginHandler;
import pl.s18280.squashclub.query.domain.login.LoginStatus;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginHandler loginHandler;

    @PostMapping
    public LoginResponse login(@RequestBody LoginForm loginForm) {
        LoginStatus status = loginHandler.handleLogin(loginForm);

        return new LoginResponse(status.getSuccess(), status.getMessage());
    }
}

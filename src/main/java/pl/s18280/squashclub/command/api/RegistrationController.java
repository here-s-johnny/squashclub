package pl.s18280.squashclub.command.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.s18280.squashclub.command.domain.registration.RegistrationHandler;
import pl.s18280.squashclub.command.domain.registration.RegistrationStatus;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationHandler registrationHandler;

    @PostMapping
    public RegistrationResponse register(@RequestBody RegistrationRequest registrationRequest) {
        RegistrationStatus status = registrationHandler.handleRegistration(registrationRequest);
        return new RegistrationResponse(
                status.getSuccess(),
                status.getMessage()
        );
    }
}
